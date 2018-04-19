package model;

public class Pictures {
    private Integer id;

    private String tbname;

    private Integer idhorseonsale;

    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname == null ? null : tbname.trim();
    }

    public Integer getIdhorseonsale() {
        return idhorseonsale;
    }

    public void setIdhorseonsale(Integer idhorseonsale) {
        this.idhorseonsale = idhorseonsale;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}