package model;

public class Swipper {
    private Integer id;

    private Integer idh;

    private String descp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdh() {
        return idh;
    }

    public void setIdh(Integer idh) {
        this.idh = idh;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp == null ? null : descp.trim();
    }
}