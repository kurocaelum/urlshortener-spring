package com.victorbrandao.url_shortener.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.repositories.ShortUrlRepository;
import com.victorbrandao.url_shortener.services.exceptions.DatabaseException;
import com.victorbrandao.url_shortener.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	
	public ShortUrl insert(ShortUrl obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			if (!repository.existsById(id))
				throw new ResourceNotFoundException(id);
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public ShortUrl update(Long id, ShortUrl obj) {
		try {
			ShortUrl entity = repository.getReferenceById(id);
			updateData(entity, obj);
				
			return repository.save(entity);
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
