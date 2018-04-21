package vo;

import javax.validation.constraints.NotNull;

public class SessionVo {
	@NotNull(message = "sessionId can't be null")
	public String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}	
