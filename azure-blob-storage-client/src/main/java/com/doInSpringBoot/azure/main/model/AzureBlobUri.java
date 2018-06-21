package com.doInSpringBoot.azure.main.model;

import java.io.Serializable;
import java.net.URI;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("azureBlobFilter")
public class AzureBlobUri implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String endpointSuffix;
	private URI primaryURI;
	private URI secondaryURI;
	private String generateSharedAccessSignature;
	private String generateBlobSharedAccessSignature;
	
	public AzureBlobUri() {	}

	public AzureBlobUri(String endpointSuffix, URI primaryURI, URI secondaryURI) {
		super();
		this.endpointSuffix = endpointSuffix;
		this.primaryURI = primaryURI;
		this.secondaryURI = secondaryURI;
	}

	public String getEndpointSuffix() {
		return endpointSuffix;
	}

	public void setEndpointSuffix(String endpointSuffix) {
		this.endpointSuffix = endpointSuffix;
	}

	public URI getPrimaryURI() {
		return primaryURI;
	}

	public void setPrimaryURI(URI primaryURI) {
		this.primaryURI = primaryURI;
	}

	public URI getSecondaryURI() {
		return secondaryURI;
	}

	public void setSecondaryURI(URI secondaryURI) {
		this.secondaryURI = secondaryURI;
	}

	public String getGenerateSharedAccessSignature() {
		return generateSharedAccessSignature;
	}

	public void setGenerateSharedAccessSignature(String generateSharedAccessSignature) {
		this.generateSharedAccessSignature = generateSharedAccessSignature;
	}
	
	public String getGenerateBlobSharedAccessSignature() {
		return generateBlobSharedAccessSignature;
	}

	public void setGenerateBlobSharedAccessSignature(String generateBlobSharedAccessSignature) {
		this.generateBlobSharedAccessSignature = generateBlobSharedAccessSignature;
	}

	@Override
	public String toString() {
		return "AzureBlobUri [endpointSuffix=" + endpointSuffix + ", primaryURI=" + primaryURI + ", secondaryURI="
				+ secondaryURI + ", generateSharedAccessSignature=" + generateSharedAccessSignature + ", generateBlobSharedAccessSignature="
				+ generateBlobSharedAccessSignature + "]";
	}

}
