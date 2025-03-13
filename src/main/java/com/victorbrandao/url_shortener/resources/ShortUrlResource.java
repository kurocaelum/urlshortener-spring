package com.victorbrandao.url_shortener.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorbrandao.url_shortener.entities.ShortUrl;

@RestController
@RequestMapping(value = "/shortUrl")
public class ShortUrlResource {
	
	@GetMapping
	public ResponseEntity<ShortUrl> findAll() {
		ShortUrl url = new ShortUrl(1L, "Teste", "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test", "https://youtu.be/M4R_XUSTCcc");
		return ResponseEntity.ok().body(url);
	}
}
