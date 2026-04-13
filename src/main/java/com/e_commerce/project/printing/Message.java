package com.e_commerce.project.printing;

public class Message {
private String msg;
private String msgType;
public Message(String msg, String msgType) {
	super();
	this.msg = msg;
	this.msgType = msgType;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getMsgType() {
	return msgType;
}
public void setMsgType(String msgType) {
	this.msgType = msgType;
}
public Message() {
	super();
	// TODO Auto-generated constructor stub
}

}
