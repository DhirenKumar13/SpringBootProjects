package com.roche.rsp.main.model;

public class GetStoragePathParameters {
	
	public DeviceStorageModel deviceStorage;

	public GetStoragePathParameters() {
		super();
	}

	public DeviceStorageModel getDeviceStorage() {
		return deviceStorage;
	}

	public void setDeviceStorage(DeviceStorageModel deviceStorage) {
		this.deviceStorage = deviceStorage;
	}

	public GetStoragePathParameters(DeviceStorageModel deviceStorage) {
		super();
		this.deviceStorage = deviceStorage;
	}


}
