package service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.SessionPojo;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import serviceinterface.SessionService;

@Service(value = "sessionService")
public class SessionServiceImpl implements SessionService {
	@Autowired
	private JedisPool pool;
	@Override
	public void add(SessionPojo sessionPojo) {
		if(sessionPojo == null) {
			throw new NullPointerException("sessionPojo is null");
		}
		if(containsKey(sessionPojo.getSessionId())) {
			return;
		}
		Jedis jedis = this.pool.getResource();
		try {
			String s = sessionPojo.getSessionId();
			jedis.set(s, sessionPojo.toJSONString());
			jedis.expire(s, 30 * 60);
			jedis.close();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SessionPojo remove(String sessionId) {
		SessionPojo sessionPojo = null;
		Jedis jedis = this.pool.getResource();
		if (containsKey(sessionId)) {
			try {
				String jsonValue = jedis.get(sessionId);
				jedis.del(sessionId);
				jedis.close();
				sessionPojo = SessionPojo.getSessionPojo(jsonValue);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sessionPojo;
	}

	@Override
	public boolean containsKey(String sessionId) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.expire(sessionId, 30 * 60);
			return jedis.exists(sessionId);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jedis.close();
		}
		return false;
	}
	

	@Override
	public SessionPojo get(String sessionId) {
		SessionPojo sessionPojo = null;
		Jedis jedis = this.pool.getResource();
		if (containsKey(sessionId)) {
			try {
				String jsonValue = jedis.get(sessionId);
				jedis.expire(sessionId, 30 * 60);
				jedis.close();
				sessionPojo = SessionPojo.getSessionPojo(jsonValue);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sessionPojo;
	}

}
