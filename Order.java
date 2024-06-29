package com.login;

public class Order extends Product{
	private int pid;
	private String uid;
	private String date;
	public Order() {}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [pid=" + pid + ", uid=" + uid + ", date=" + date + "]";
	}
	

	
	
	

	


}
