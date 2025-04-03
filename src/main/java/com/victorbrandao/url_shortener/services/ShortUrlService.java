package com.victorbrandao.url_shortener.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.victorbrandao.url_shortener.dto.ShortUrlCreationDTO;
import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.repositories.ShortUrlRepository;
import com.victorbrandao.url_shortener.services.exceptions.DatabaseException;
import com.victorbrandao.url_shortener.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShortUrlService {

	@Autowired
	private ShortUrlRepository shortUrlRepository;
		
	@Autowired
	private UserService userService;
	
	public ShortUrl fromCreationDTO(ShortUrlCreationDTO objDto) {
		// TODO gerar lógica de encurtamento e substituir valor fixo passado em urlShortened
		ShortUrl obj = new ShortUrl();
		obj.setIdentifier(objDto.getIdentifier());
		obj.seturlOriginal(objDto.getUrlOriginal());
		obj.seturlShortened("https://www.youtube.com/watch?v=d7SYy5JvyOA");
		obj.setUser(userService.findById(objDto.getUserId()));
				
		return obj;
	}
	
	public List<ShortUrl> findAll() {
		return shortUrlRepository.findAll();
	}
	
	public ShortUrl findById(Long id) {
		Optional<ShortUrl> obj = shortUrlRepository.findById(id);
		return obj.get();
	}
	
	public ShortUrl insert(ShortUrl obj) {
		return shortUrlRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			if (!shortUrlRepository.existsById(id))
				throw new ResourceNotFoundException(id);
			shortUrlRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public ShortUrl update(Long id, ShortUrl obj) {
		try {
			ShortUrl entity = shortUrlRepository.getReferenceById(id);
			updateData(entity, obj);
				
			return shortUrlRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(ShortUrl entity, ShortUrl obj) {
		entity.setIdentifier(obj.getIdentifier());
		entity.seturlOriginal(obj.geturlOriginal());
		entity.seturlShortened(obj.geturlShortened());
	}
}
