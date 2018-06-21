package com.doInSpringBoot.azure.main.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.EnumSet;

import com.doInSpringBoot.azure.main.model.AzureBlobUri;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.SharedAccessAccountPermissions;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;

public interface AzureBlobService {
	
	public String getConnectionString(String protocol,String accountName,String accountKey,String suffix);
	public CloudStorageAccount createCloudStorageAccount(String storageConnectionString) throws InvalidKeyException, URISyntaxException;
	public EnumSet<SharedAccessAccountPermissions> setAccountPermissions();
	public EnumSet<SharedAccessBlobPermissions> setBlobPermissions();
	public Boolean createContainer(CloudBlobContainer container) throws StorageException;
	public void uploadFileContent(CloudBlobContainer container , File file) throws URISyntaxException, StorageException, IOException;
	public AzureBlobUri generateAzureBlobUri(CloudStorageAccount storageAccount);
}
