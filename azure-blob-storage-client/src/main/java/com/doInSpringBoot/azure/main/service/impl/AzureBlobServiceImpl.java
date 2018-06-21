package com.doInSpringBoot.azure.main.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import org.springframework.stereotype.Service;

import com.doInSpringBoot.azure.main.model.AzureBlobUri;
import com.doInSpringBoot.azure.main.service.AzureBlobService;
import com.doInSpringBoot.azure.main.utility.AzureBlobUtilities;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.SharedAccessAccountPermissions;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;

@Service
public class AzureBlobServiceImpl implements AzureBlobService {

	@Override
	public String getConnectionString(String protocol, String accountName, String accountKey, String suffix) {
		return AzureBlobUtilities.getConnectionString(protocol, accountName, accountKey, suffix);
	}

	@Override
	public CloudStorageAccount createCloudStorageAccount(String storageConnectionString) throws InvalidKeyException, URISyntaxException {
		return AzureBlobUtilities.createCloudStorageAccount(storageConnectionString);
	}

	@Override
	public EnumSet<SharedAccessAccountPermissions> setAccountPermissions() {
		Collection<SharedAccessAccountPermissions> collectionEnum = new ArrayList<>();
		collectionEnum.add(SharedAccessAccountPermissions.READ);
		collectionEnum.add(SharedAccessAccountPermissions.WRITE);
		collectionEnum.add(SharedAccessAccountPermissions.ADD);
		collectionEnum.add(SharedAccessAccountPermissions.CREATE);
		collectionEnum.add(SharedAccessAccountPermissions.DELETE);
		collectionEnum.add(SharedAccessAccountPermissions.PROCESS_MESSAGES);
		collectionEnum.add(SharedAccessAccountPermissions.UPDATE);
		return EnumSet.copyOf(collectionEnum);
	}

	@Override
	public EnumSet<SharedAccessBlobPermissions> setBlobPermissions() {
		Collection<SharedAccessBlobPermissions> collectionEnum = new ArrayList<>();
		collectionEnum.add(SharedAccessBlobPermissions.READ);
		collectionEnum.add(SharedAccessBlobPermissions.WRITE);
		collectionEnum.add(SharedAccessBlobPermissions.CREATE);
		collectionEnum.add(SharedAccessBlobPermissions.DELETE);
		collectionEnum.add(SharedAccessBlobPermissions.LIST);
		collectionEnum.add(SharedAccessBlobPermissions.ADD);
		return EnumSet.copyOf(collectionEnum);
	}

	@Override
	public Boolean createContainer(CloudBlobContainer container) throws StorageException {
		return container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER,
				new BlobRequestOptions(), new OperationContext());
	}

	@Override
	public void uploadFileContent(CloudBlobContainer container, File file) throws URISyntaxException, StorageException, IOException {
		CloudBlockBlob blob = container.getBlockBlobReference(file.getName());
		blob.uploadFromFile(file.getAbsolutePath());
	}

	@Override
	public AzureBlobUri generateAzureBlobUri(CloudStorageAccount storageAccount) {
		StorageUri blobStorageUri = storageAccount.getBlobStorageUri();
		return new AzureBlobUri(storageAccount.getEndpointSuffix(),
				blobStorageUri.getPrimaryUri(), blobStorageUri.getSecondaryUri());
	}

}
