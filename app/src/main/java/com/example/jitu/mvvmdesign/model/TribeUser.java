
package com.example.jitu.mvvmdesign.model;

import java.util.HashMap;
import java.util.Map;

public class TribeUser {

    private String challengeCount;
    private String tribeId;
    private String owner;
    private String userId;
    private String title;
    private String description;
    private String coverimage;
    private String fullimage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getChallengeCount() {
        return challengeCount;
    }

    public void setChallengeCount(String challengeCount) {
        this.challengeCount = challengeCount;
    }

    public String getTribeId() {
        return tribeId;
    }

    public void setTribeId(String tribeId) {
        this.tribeId = tribeId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public String getFullimage() {
        return fullimage;
    }

    public void setFullimage(String fullimage) {
        this.fullimage = fullimage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
