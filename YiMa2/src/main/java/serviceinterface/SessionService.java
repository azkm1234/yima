package serviceinterface;

import model.SessionPojo;
//������service��
public interface SessionService {
	void add(SessionPojo sessoionPojo);
	SessionPojo remove(String sessionId);
	SessionPojo get(String sessionId);
	boolean containsKey(String sessionId);
}
