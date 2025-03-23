package com.victorbrandao.url_shortener.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.repositories.ShortUrlRepository;

@Service
public class ShortUrlService {

	@Autowired
	private ShortUrlRepository repository;
	
	public List<ShortUrl> findAll() {
		return repository.findAll();
	}
	
	public ShortUrl findById(Long id) {
		Optional<ShortUrl> obj = repository.findById(id);
		return obj.get();
	}
}
