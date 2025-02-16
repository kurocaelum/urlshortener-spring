package com.victorbrandao.url_shortener.entities;

import java.io.Serializable;
import java.util.Objects;

public class URLShort implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String identifier;
	private String urlOriginal;
	private String urlShortened;
	
	public URLShort(){}

	public URLShort(Long id, String identifier, String urlOriginal, String urlShortened) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.urlOriginal = urlOriginal;
		this.urlShortened = urlShortened;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String geturlOriginal() {
		return urlOriginal;
	}

	public void seturlOriginal(String uRLOriginal) {
		urlOriginal = uRLOriginal;
	}

	public String geturlShortened() {
		return urlShortened;
	}

	public void seturlShortened(String uRLShortened) {
		urlShortened = uRLShortened;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URLShort other = (URLShort) obj;
		return Objects.equals(id, other.id);
	}
	
}
