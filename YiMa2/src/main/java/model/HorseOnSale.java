package model;

import java.util.Date;

import javax.validation.constraints.NotNull;



public class HorseOnSale {
    private Integer id;
    
    @NotNull(message = "username can't be null")
    private String username;
    
    private Date time;
    
    private String title;
    
    private String sex;

    private String horsetype;

    private String address;
    
    private String color;

    private String speciality;

    private String parents;
    
    @NotNull(message = "description can't be null")
    private String description;

    private String picture;

    private Integer age;

    private Integer height;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHorsetype() {
        return horsetype;
    }

    public void setHorsetype(String horsetype) {
        this.horsetype = horsetype == null ? null : horsetype.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents == null ? null : parents.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}