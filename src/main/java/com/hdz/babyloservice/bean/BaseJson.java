package com.hdz.babyloservice.bean;

public class BaseJson<T> {
	private int code;    //�Ƿ�����ɹ�,��֤��
	private T data; //����
	private String msg;  //�������
	private String version;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
