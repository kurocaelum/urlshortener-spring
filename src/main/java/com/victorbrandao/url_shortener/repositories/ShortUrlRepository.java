package com.victorbrandao.url_shortener.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorbrandao.url_shortener.entities.ShortUrl;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
	Optional<ShortUrl> findByUrlShortened(String shortUrl);
}
