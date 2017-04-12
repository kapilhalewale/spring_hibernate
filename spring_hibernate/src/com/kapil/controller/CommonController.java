package com.kapil.controller;

import org.springframework.web.bind.annotation.ModelAttribute;


public class CommonController
{
	private String basePath = "http://localhost:8080/spring_hibernate";

	@ModelAttribute("basePath")
	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
