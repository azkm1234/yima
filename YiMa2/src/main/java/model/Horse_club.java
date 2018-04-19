package model;

public class Horse_club extends Horse_clubKey {
    private String clubaddr;

    private String title;

    private String picture;

    private String description;

    public String getClubaddr() {
        return clubaddr;
    }

    public void setClubaddr(String clubaddr) {
        this.clubaddr = clubaddr == null ? null : clubaddr.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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