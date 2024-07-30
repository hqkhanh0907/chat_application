package com.raven.model;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class Model_User_Account {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Model_User_Account(int userID, String userName, String gender, String image, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.image = image;
        this.status = status;
    }

    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            userID = obj.getInt("userID");
            userName = obj.getString("userName");
            gender = (obj.has("gender") && Objects.nonNull(obj.getString("gender"))) ? obj.getString("gender") : null;
            image = (obj.has("image") && Objects.nonNull(obj.getString("image"))) ? obj.getString("image") : null;
            status = (obj.has("status") && Objects.nonNull(obj.getBoolean("status"))) ? obj.getBoolean("status") : null;
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    private int userID;
    private String userName;
    private String gender;
    private String image;
    private boolean status;
}
