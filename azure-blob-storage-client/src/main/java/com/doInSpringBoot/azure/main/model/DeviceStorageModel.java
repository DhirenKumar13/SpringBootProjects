package com.doInSpringBoot.azure.main.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DeviceStorageModel {
	
	@NotEmpty
	@Size(min=2 , message="Rudi should be greater than 2 characters")
	private String rudi;
	
	@NotEmpty(message="requestedStorageSize shouldn't be empty")
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
