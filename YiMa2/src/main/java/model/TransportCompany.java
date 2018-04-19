package model;

import org.springframework.util.StringUtils;

import com.sun.istack.internal.NotNull;

public class TransportCompany {
    private Integer id;

    @NotNull
    private String username;
    
    @NotNull
    private String contacts;

    @NotNull
    private String title;

    @NotNull
    private String phone;

    @NotNull
    private String description;
    
    public boolean check() {
    	if (StringUtils.isEmpty(username) 
    			|| StringUtils.isEmpty(contacts)
    			|| StringUtils.isEmpty(phone)
    			|| StringUtils.isEmpty(description)) {
    		return false;
    	}
    	return true;
    }
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
}