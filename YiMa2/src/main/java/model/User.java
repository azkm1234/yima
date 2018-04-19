package model;

import java.util.Date;

public class User {
    private String username;

    private String pswmd5;

    private String salt;

    private String headimage;

    private Date regtime;

    private String phone;

    private String addr;

    private String email;

    private String wexin;

    private String qq;

    private String description;

    private Boolean expert;
    public User(String username, String password) {
    	this.username = username;
    	this.pswmd5 = password;
    }
    public User() {
		
	}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPswmd5() {
        return pswmd5;
    }

    public void setPswmd5(String pswmd5) {
        this.pswmd5 = pswmd5 == null ? null : pswmd5.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWexin() {
        return wexin;
    }

    public void setWexin(String wexin) {
        this.wexin = wexin == null ? null : wexin.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getExpert() {
        return expert;
    }

    public void setExpert(Boolean expert) {
        this.expert = expert;
    }
}