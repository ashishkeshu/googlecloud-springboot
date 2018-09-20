package com.firekernel.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.firekernel.demo.model.StorageResponse;

public interface StorageService {
	StorageResponse storeFile(MultipartFile multipartFile);

	StorageResponse loadFile(String fileUri);

	ResponseEntity<?> deleteFile(String fileUri);
}
