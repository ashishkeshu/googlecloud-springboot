package com.firekernel.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firekernel.demo.model.StorageResponse;
import com.firekernel.demo.service.StorageService;

@RestController
@RequestMapping("/v1")
public class StorageController {

	@Autowired
	private StorageService storageService;

	@PostMapping("/storage/upload")
	public StorageResponse upload(@RequestParam("file") MultipartFile file) {
		return storageService.storeFile(file);
	}

	@GetMapping("/storage/download/{fileUri:.+}")
	public StorageResponse download(@PathVariable String fileUri) {
		return storageService.loadFile(fileUri);
	}

	@DeleteMapping("/storage/delete/{fileUri:.+}")
	public ResponseEntity<?> delete(@PathVariable String fileUri) {
		return storageService.deleteFile(fileUri);
	}
}