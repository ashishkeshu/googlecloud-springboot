package com.firekernel.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.firekernel.demo.exception.ErrorCode;
import com.firekernel.demo.model.ExceptionResponse;
import com.firekernel.demo.model.FireFile;
import com.firekernel.demo.model.StorageResponse;

/**
 * Spring Framework provides a ResourceLoader abstraction to easily read and
 * write files from various sources, such as the filesystem, the classpath, or
 * the web. You simply need to specify the URI to the resource using the well
 * known protocol prefix. For example, to access a file on the local filesystem,
 * you would specify a URI like file:/data/config.yaml.
 * 
 * Service will access files stored in Google Cloud Storage (GCS) using the
 * Spring Resource abstraction and the gs: protocol prefix.
 * 
 * @author Ashish Kumar
 */

@Service
public class StorageServiceImpl implements StorageService {
	private static final Logger LOGGER = Logger.getLogger(StorageServiceImpl.class.getSimpleName());

	// Google Cloud Storage Path
	@Value("${google.cloud.storage.bucket.name}")
	private Resource gcsFile;

	private int MAX_BUFFER_SIZE = 10 * 1024 * 1024;

	@Override
	public StorageResponse storeFile(MultipartFile multipartFile) {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		try {
			InputStream is = multipartFile.getInputStream();
			Resource relativeFile = gcsFile.createRelative(fileName);
			OutputStream os = ((WritableResource) relativeFile).getOutputStream();
			// IOUtils.copy(is, os);
			copy(is, os);
			return new StorageResponse(new FireFile(fileName, relativeFile.getURI().toString(),
					multipartFile.getContentType(), multipartFile.getSize()));
		} catch (Exception e) {
			return new StorageResponse(new ExceptionResponse(ErrorCode.ERROR.getCode(), e.getMessage()));
		}
	}

	@Override
	public StorageResponse loadFile(String fileUri) {
		String fileName = fileUri;

		try {
			Resource relativeFile = gcsFile.createRelative(fileName);
			return new StorageResponse(new FireFile(fileName, relativeFile.getURL().toString(), "", 0L));
		} catch (IOException e) {
			return new StorageResponse(new ExceptionResponse(ErrorCode.ERROR.getCode(), "File Not Found"));
		}

	}

	@Override
	public ResponseEntity<?> deleteFile(String fileUri) {
		return ResponseEntity.ok().build();
	}

	private void copy(InputStream is, OutputStream os) throws Exception {
		byte[] buffer = new byte[MAX_BUFFER_SIZE];
		int bytesRead = is.read(buffer);
		while (bytesRead != -1) {
			os.write(buffer, 0, bytesRead);
			bytesRead = is.read(buffer);
		}
		is.close();
		os.close();
	}

}