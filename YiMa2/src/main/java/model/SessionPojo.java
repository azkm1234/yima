package model;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SessionPojo {
	private String sessionId;
	private String username;
	private long timestamp;
	public boolean isNew(long currenttime) {
		return currenttime - timestamp < 600000;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public SessionPojo() {
		
	}
	public SessionPojo(String sid, String username, long time) {
		this.sessionId = sid;
		this.username = username;
		this.timestamp = time;
	}
	public String toJSONString() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
	public static SessionPojo getSessionPojo(String jsonValue) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonValue, SessionPojo.class);
	}
}
