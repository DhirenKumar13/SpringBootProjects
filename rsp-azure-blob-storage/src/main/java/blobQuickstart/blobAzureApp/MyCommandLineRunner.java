package blobQuickstart.blobAzureApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import blobQuickstart.blobAzureApp.service.AzureAppService;

@Service
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private AzureAppService azureAppService;
	
	@Override
	public void run(String... args) throws Exception {
		azureAppService.serviceClass();
	}

}
