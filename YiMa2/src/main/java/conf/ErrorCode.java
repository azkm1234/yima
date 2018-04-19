package conf;

public enum ErrorCode {
	ERRORCODE_SUCCESS(10000, "success"),
	ERRORCODE_FAIL(10001, "failure"),
	ERRORCODE_MISSING_PARAM(10002, "È±ÉÙ²ÎÊý");
	private int code;
	private String msg;
	private ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return this.code;
	}
	public String getMsg() {
		return this.msg;
	}
}
