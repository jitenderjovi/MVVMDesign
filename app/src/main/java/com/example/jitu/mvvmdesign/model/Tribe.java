package com.example.jitu.mvvmdesign.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jitu on 07/03/17.
 */

public class Tribe {

    @SerializedName("tribe_id")
    @Expose
    private String tribe_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("challenge_count")
    @Expose
    private String challenge_count;

    @SerializedName("coverimage")
    @Expose
    private String coverimage;

    public String getTribe_id() {
        return tribe_id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setTribe_id(String id) {
        this.tribe_id = tribe_id;
    }

    public String getTitle(){ return title;}
    public void setTitle(String title){this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getCoverimage() {return coverimage;}
    public void setCoverimage(String coverimage){this.coverimage = coverimage;}
}
