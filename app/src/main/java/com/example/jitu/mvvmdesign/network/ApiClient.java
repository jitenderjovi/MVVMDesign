package com.example.jitu.mvvmdesign.network;

import com.example.jitu.mvvmdesign.model.UserResponse;
import com.example.jitu.mvvmdesign.serviceRequest.ServiceCallback;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class ApiClient {

    private static final String CACHE_CONTROL = "Cache-Control";
    private static Retrofit retrofit = null;
    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor( provideOfflineCacheInterceptor())
            .addNetworkInterceptor( provideCacheInterceptor() )
            .cache(provideCache());

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(DemoConfig.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }


    private static Cache provideCache ()
    {
        Cache cache = null;
        try
        {
            cache = new Cache( new File(AdeptAndroid.getInstance().getCacheDir(), "http-cache" ),
                    10 * 1024 * 1024 ); // 10 MB
        }
        catch (Exception e)
        {
            System.out.println("Could not create Cache!"+e.getMessage());
            //Timber.e( e, "Could not create Cache!" );
        }
        return cache;
    }

    public static Interceptor provideCacheInterceptor ()
    {
        return new Interceptor()
        {
            @Override
            public okhttp3.Response intercept (Chain chain) throws IOException
            {
                okhttp3.Response response = chain.proceed( chain.request() );

                // re-write response header to force use of cache
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge( 2, TimeUnit.MINUTES )
                        .build();

                return response.newBuilder()
                        .header( CACHE_CONTROL, cacheControl.toString() )
                        .build();
            }
        };
    }

    public static Interceptor provideOfflineCacheInterceptor ()
    {
        return new Interceptor()
        {
            @Override
            public okhttp3.Response intercept (Chain chain) throws IOException
            {
                Request request = chain.request();

                if ( !AdeptAndroid.hasNetwork() )
                {
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxStale( 7, TimeUnit.DAYS )
                            .build();

                    request = request.newBuilder()
                            .cacheControl( cacheControl )
                            .build();
                }

                return chain.proceed( request );
            }
        };
    }

    //http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1

    public static <T> void hitServer(Call<T> call, final ServiceCallback<T> callback){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

                callback.onSuccess(response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onError("Server Error",t.getMessage());
            }
        });

    }
}
