package com.victorbrandao.url_shortener.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.victorbrandao.url_shortener.dto.ShortUrlCreationDTO;
import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.services.ShortUrlService;

@RestController
@RequestMapping(value = "/shorturls")
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
	
	@GetMapping(value = "/source/{urlFrag}")
	public ResponseEntity<ShortUrl> findByShortUrl(@PathVariable String urlFrag) {
		ShortUrl obj = service.findByShortUrl(urlFrag);
		return ResponseEntity.ok().body(obj);
	}
		
	@PostMapping
	public ResponseEntity<ShortUrl> insert(@RequestBody ShortUrlCreationDTO objDto) {
		ShortUrl obj = service.fromCreationDTO(objDto);
		obj = service.insert(obj);
		
		obj.seturlShortened(service.encode(obj.getId()));
		obj = service.update(obj.getId(), obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ShortUrl> update(@PathVariable Long id, @RequestBody ShortUrl obj) {
		obj = service.update(id, obj);
		
		return ResponseEntity.ok().body(obj);
	}
}
