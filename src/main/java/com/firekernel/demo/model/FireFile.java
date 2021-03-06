package com.firekernel.demo.model;

public class FireFile {
	private String name;
	private String downloadUri;
	private String type;
	private long size;

	public FireFile(String name, String downloadUri, String type, long size) {
		this.name = name;
		this.downloadUri = downloadUri;
		this.type = type;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDownloadUri() {
		return downloadUri;
	}

	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
