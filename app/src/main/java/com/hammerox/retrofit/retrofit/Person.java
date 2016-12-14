package com.hammerox.retrofit.retrofit;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String personID;
    private String name;
    private String username;
    private String email;
    private String image;
    private String facebookID;
    private String linkedInID;
    private String twitterID;
    private String tokenID;
    private String scope;
    private String targetID;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The personID
     */
    public String getPersonID() {
        return personID;
    }

    /**
     *
     * @param personID
     * The personID
     */
    public void setPersonID(String personID) {
        this.personID = personID;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The facebookID
     */
    public String getFacebookID() {
        return facebookID;
    }

    /**
     *
     * @param facebookID
     * The facebookID
     */
    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    /**
     *
     * @return
     * The linkedInID
     */
    public String getLinkedInID() {
        return linkedInID;
    }

    /**
     *
     * @param linkedInID
     * The linkedInID
     */
    public void setLinkedInID(String linkedInID) {
        this.linkedInID = linkedInID;
    }

    /**
     *
     * @return
     * The twitterID
     */
    public String getTwitterID() {
        return twitterID;
    }

    /**
     *
     * @param twitterID
     * The twitterID
     */
    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }

    /**
     *
     * @return
     * The tokenID
     */
    public String getTokenID() {
        return tokenID;
    }

    /**
     *
     * @param tokenID
     * The tokenID
     */
    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    /**
     *
     * @return
     * The scope
     */
    public String getScope() {
        return scope;
    }

    /**
     *
     * @param scope
     * The scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     *
     * @return
     * The targetID
     */
    public String getTargetID() {
        return targetID;
    }

    /**
     *
     * @param targetID
     * The targetID
     */
    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}