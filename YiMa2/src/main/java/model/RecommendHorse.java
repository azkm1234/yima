package model;

public class RecommendHorse {
    public RecommendHorse(Integer id, String username, Integer idhorseonsale) {
		super();
		this.id = id;
		this.username = username;
		this.idhorseonsale = idhorseonsale;
	}
    public RecommendHorse() {
    	
    }
	private Integer id;

    private String username;

    private Integer idhorseonsale;

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
}