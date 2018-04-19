package service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service(value = "randomGenerator")
public class RandomGenerator {
	private static final int SESSION_ID_BYTES = 16;
	public static synchronized String generateSessionId() {
	        // Generate a byte array containing a session identifier
	        Random random = new SecureRandom();  // ȡ�����������, Ĭ����SecureRandom
	        byte bytes[] = new byte[SESSION_ID_BYTES];
	        random.nextBytes(bytes); //����16�ֽڵ�byte
	        // Render the result as a String of hexadecimal digits
	        StringBuffer result = new StringBuffer();
	        for (int i = 0; i < bytes.length; i++) {     //ת��Ϊ16�����ַ���
	            byte b1 = (byte) ((bytes[i] & 0xf0) >> 4);
	            byte b2 = (byte) (bytes[i] & 0x0f);
	            if (b1 < 10)
	                result.append((char) ('0' + b1));
	            else
	                result.append((char) ('A' + (b1 - 10)));
	            if (b2 < 10)
	                result.append((char) ('0' + b2));
	            else
	                result.append((char) ('A' + (b2 - 10)));
	        }
	        return (result.toString());
	    }
}