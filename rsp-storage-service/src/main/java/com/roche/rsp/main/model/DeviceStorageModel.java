package com.roche.rsp.main.model;

public class DeviceStorageModel {
	private String rudi;
	private String requestedStorageSize;
	public DeviceStorageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceStorageModel(String rudi, String size) {
		super();
		this.rudi = rudi;
		this.requestedStorageSize = size;
	}
	public String getRudi() {
		return rudi;
	}
	public void setRudi(String rudi) {
		this.rudi = rudi;
	}
	public String getRequestedstoragesize() {
		return requestedStorageSize;
	}
	public void setRequestedstoragesize(String size) {
		this.requestedStorageSize = size;
	}
	

}
