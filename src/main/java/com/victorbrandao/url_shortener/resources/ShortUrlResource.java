package com.victorbrandao.url_shortener.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.services.ShortUrlService;

@RestController
@RequestMapping(value = "/shortUrl")
public class ShortUrlResource {
	
	@Autowired
	private ShortUrlService service;
	
	@GetMapping
	public ResponseEntity<List<ShortUrl>> findAll() {
		List<ShortUrl> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ShortUrl> findById(@PathVariable Long id) {
		ShortUrl obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
