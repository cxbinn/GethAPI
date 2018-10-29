package com.example.demo.entity;

public class Account {
	public String address;
	public String password;
	public int createdate;
	public int lasttime;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCreatedate() {
		return createdate;
	}
	public void setCreatedate(int createdate) {
		this.createdate = createdate;
	}
	public int getLasttime() {
		return lasttime;
	}
	public void setLasttime(int lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "Account [address=" + address + ", password=" + password
				+ ", createdate=" + createdate + ", lasttime=" + lasttime + "]";
	}


}
