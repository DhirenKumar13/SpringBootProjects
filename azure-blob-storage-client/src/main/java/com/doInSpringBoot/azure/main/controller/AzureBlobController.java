package com.doInSpringBoot.azure.main.controller;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.EnumSet;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doInSpringBoot.azure.main.model.AzureBlobUri;
import com.doInSpringBoot.azure.main.model.DeviceStorageModel;
import com.doInSpringBoot.azure.main.model.GetStoragePathParameters;
import com.doInSpringBoot.azure.main.service.AzureBlobService;
import com.doInSpringBoot.azure.main.utility.AzureBlobUtilities;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.SharedAccessAccountPermissions;
import com.microsoft.azure.storage.SharedAccessAccountPolicy;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;

@RestController
public class AzureBlobController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AzureBlobService azureBlobService;

	@Value("${default.endpoints.protocol}")
	private String protocol;

	@Value("${account.name}")
	private String accountName;

	@Value("${account.key}")
	private String accountKey;

	@Value("${endpoint.suffix}")
	private String accountSuffix;

	@PostMapping("/azure-blob-storage")
	public MappingJacksonValue getAzureBlobDetails(@Valid @RequestBody GetStoragePathParameters request) 
			throws InvalidKeyException, URISyntaxException, StorageException {

		DeviceStorageModel deviceStorage = request.getDeviceStorage();
		CloudStorageAccount storageAccount = null;
		CloudBlobClient createBlobClient = null;
		CloudBlobContainer container = null;

		String requestedstoragesize = deviceStorage.getRequestedstoragesize();
		String rudi = deviceStorage.getRudi();

		String connectionString = AzureBlobUtilities.getConnectionString(protocol, accountName, accountKey,
				accountSuffix);
		SharedAccessAccountPolicy accountPolicy = new SharedAccessAccountPolicy();
		SharedAccessBlobPolicy policy = new SharedAccessBlobPolicy();

		storageAccount = azureBlobService.createCloudStorageAccount(connectionString);

		createBlobClient = storageAccount.createCloudBlobClient();

		EnumSet<SharedAccessAccountPermissions> setAccountPermissions = azureBlobService.setAccountPermissions();
		accountPolicy.setPermissions(setAccountPermissions);

		container = createBlobClient.getContainerReference(rudi.toLowerCase().replace("^","-"));

		EnumSet<SharedAccessBlobPermissions> setBlobPermissions = azureBlobService.setBlobPermissions();
		policy.setPermissions(setBlobPermissions);

		String generateSharedAccessSignature = storageAccount.generateSharedAccessSignature(accountPolicy);
		String generateBlobSharedAccessSignature = container.generateSharedAccessSignature(policy, "rsp_resources");

		AzureBlobUri uri = azureBlobService.generateAzureBlobUri(storageAccount);
		uri.setGenerateSharedAccessSignature(generateSharedAccessSignature);
		uri.setGenerateBlobSharedAccessSignature(generateBlobSharedAccessSignature);

		Boolean createContainer = azureBlobService.createContainer(container);

		String status = (createContainer == true) ? "Success" : "Failure";

		LOGGER.debug("Container Creation Status : ",status);
		
		SimpleBeanPropertyFilter requiredFilteredData = SimpleBeanPropertyFilter.filterOutAllExcept
				("endpointSuffix" ,"primaryURI" , "secondaryURI", "generateBlobSharedAccessSignature");
		
		FilterProvider filteredData = new SimpleFilterProvider().addFilter("azureBlobFilter", requiredFilteredData);
		
		MappingJacksonValue valueMapper = new MappingJacksonValue(uri);
		
		valueMapper.setFilters(filteredData);

		return valueMapper ;
	}
}
