package com.spring.sideproject.common.filepath;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommonFilePath {

	@Bean
	public String uploadFilePath() {
		return "C:\\SideProject\\CorporateRecruit\\uploadFilePath";
	}
}
