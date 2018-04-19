package model;

public class IdinHorseOnSale {
    private Integer id;

    private String username;

    private String page;

    private Integer idinhoreseonsale;

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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public Integer getIdinhoreseonsale() {
        return idinhoreseonsale;
    }

    public void setIdinhoreseonsale(Integer idinhoreseonsale) {
        this.idinhoreseonsale = idinhoreseonsale;
    }
}