package util;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import conf.Const;
import conf.ErrorCode;

public class ResultTools {
	private static final Logger logger = LoggerFactory.getLogger(ResultTools.class);
	
	public static String buildResultString(ErrorCode code, String errMsg, Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put(Const.STATUS, code.getCode());
		map.put(Const.MSG, errMsg);
		map.put(Const.VALUE, value);
		return JSON.toJSONString(map);
	}
	
	public static String buildResultString(ErrorCode code, Map<String, String>errMsg, Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put(Const.STATUS, code.getCode());
		map.put(Const.MSG, errMsg);
		map.put(Const.VALUE, value);
		return JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	public static String returnAndRecordLog(ErrorCode code, String errMsg, 
			Object value, String url, Long startTime) {
		String resString = buildResultString(code, errMsg, value);
		long endTime = System.currentTimeMillis();
		StringBuffer buffer = new StringBuffer().append("[")
				.append(url)
				.append("], durition : ")
				.append(endTime - startTime);
		if (code.equals(ErrorCode.ERRORCODE_SUCCESS)) {
			logger.info(buffer.toString());
		} else {
			logger.error(buffer.toString());
		}
		return resString;
	}
	
}
