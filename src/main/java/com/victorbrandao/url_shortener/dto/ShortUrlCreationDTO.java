package com.victorbrandao.url_shortener.dto;

import java.io.Serializable;

public class ShortUrlCreationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String identifier;
	private String urlOriginal;
	private long userId;
	
	public ShortUrlCreationDTO() {
		super();
	}

	public ShortUrlCreationDTO(String identifier, String urlOriginal, long userId) {
		super();
		this.identifier = identifier;
		this.urlOriginal = urlOriginal;
		this.userId = userId;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
