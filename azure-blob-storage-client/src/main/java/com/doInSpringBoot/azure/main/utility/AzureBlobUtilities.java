package com.doInSpringBoot.azure.main.utility;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

@Component
public class AzureBlobUtilities {
	
	private static final String SEMI_COLON = ";";
	
	public static String getConnectionString(String protocol,String accountName,String accountKey,String suffix) {
		
		return "DefaultEndpointsProtocol="+protocol+SEMI_COLON +
				"AccountName="+accountName+SEMI_COLON +
				"AccountKey="+accountKey+SEMI_COLON+"EndpointSuffix="+suffix;
		
	}
	
	public static CloudStorageAccount createCloudStorageAccount(String storageConnectionString) throws InvalidKeyException, URISyntaxException {
		return CloudStorageAccount.parse(storageConnectionString);
	}
	
	public static List<URI> getUris(CloudBlobContainer container) {
		List<URI> listuri = new ArrayList<>();
		container.listBlobs().forEach(blob -> listuri.add(blob.getUri()));
		return listuri;
	}
	
}
