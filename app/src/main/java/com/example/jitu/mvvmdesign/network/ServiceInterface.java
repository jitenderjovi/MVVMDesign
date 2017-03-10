package com.example.jitu.mvvmdesign.network;

/**
 * Created by Jitu on 04/10/16.
 */

public interface ServiceInterface {

    interface GetloginUser {
        void onRequestCompleted(String statuscode);

    }

    void onRequestCompleted(String statuscode);
}
