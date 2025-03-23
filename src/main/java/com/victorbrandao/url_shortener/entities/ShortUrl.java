package com.victorbrandao.url_shortener.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "short_url")
public class ShortUrl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String identifier;
	private String urlOriginal;
	private String urlShortened;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public ShortUrl(){}

	public ShortUrl(Long id, String identifier, String urlOriginal, String urlShortened, User user) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.urlOriginal = urlOriginal;
		this.urlShortened = urlShortened;
		this.user = user;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		ShortUrl other = (ShortUrl) obj;
		return Objects.equals(id, other.id);
	}
	
}
