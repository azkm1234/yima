package model;

import org.springframework.util.StringUtils;

import com.sun.istack.internal.NotNull;

public class Ride {
    private Integer id;
    
    @NotNull
    private String username;

    @NotNull
    private String contacts;

    private String title;

    @NotNull
    private String phone;

    @NotNull
    private String description;

    private String picture;

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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

	public boolean check() {
		if (StringUtils.isEmpty(contacts) || 
				StringUtils.isEmpty(description) || 
				StringUtils.isEmpty(phone)) {
			return false;
		}
		return true;
	}
}