package com.doInSpringBoot.azure.main.model;

import javax.validation.constraints.NotNull;

public class GetStoragePathParameters {
	
	@NotNull
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
