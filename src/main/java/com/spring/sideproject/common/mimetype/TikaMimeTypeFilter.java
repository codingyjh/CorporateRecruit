package com.spring.sideproject.common.mimetype;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

public class TikaMimeTypeFilter extends ExtensionFilter {

	@Override
	protected String getMimeType(File currentFile) {
		String mimeType = null;
	    try {
	    	Tika tika = new Tika();
			mimeType = tika.detect(currentFile);
		} catch (IOException e) {}

		return mimeType;
	}

	@Override
	protected boolean isEquals(String mimeTypeOfFile, String extension) {
		if ( mimeTypeOfFile.equalsIgnoreCase( extension.toUpperCase() ) ) {
			return true;
		}
		return false;
	}

}
