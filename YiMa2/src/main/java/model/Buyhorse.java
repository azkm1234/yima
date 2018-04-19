package model;

import java.util.Date;

public class Buyhorse {
    private String username;

    private Date timest;

    private String picture;

    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getTimest() {
        return timest;
    }

    public void setTimest(Date timest) {
        this.timest = timest;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}