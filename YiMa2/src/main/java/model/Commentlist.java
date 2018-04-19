package model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Commentlist {
    private Integer id;
    
    @NotNull(message = "username can't be null")
    private String username;
    
    @NotNull(message = "horse id can't be null")
    private Integer idhorseonsale;

    @NotNull(message = "comment can't be null")
    private String comment;

    private Date time;

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

    public Integer getIdhorseonsale() {
        return idhorseonsale;
    }

    public void setIdhorseonsale(Integer idhorseonsale) {
        this.idhorseonsale = idhorseonsale;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    public String toString() {
    	return "马 id：" + this.idhorseonsale + "  评论人" + this.username + "  评论：" + this.comment;
    }
}