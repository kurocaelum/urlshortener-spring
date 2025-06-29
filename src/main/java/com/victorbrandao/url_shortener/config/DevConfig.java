package com.victorbrandao.url_shortener.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.entities.User;
import com.victorbrandao.url_shortener.repositories.ShortUrlRepository;
import com.victorbrandao.url_shortener.repositories.UserRepository;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

	@Autowired
	private ShortUrlRepository shortUrlRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User u1 = new User(null, "Victor", "123456");
//		User u2 = new User(null, "Jiraya", "123456");
//		
//		ShortUrl s1 = new ShortUrl(null, "Teste 1", "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test", "https://short.url/00001", u1, LocalDate.of(2025, 4, 15));
//		ShortUrl s2 = new ShortUrl(null, "Teste 2", "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test", "https://short.url/00002", u2, LocalDate.of(2013, 4, 7));
//		
//		
//		userRepository.saveAll(Arrays.asList(u1, u2));
//		shortUrlRepository.saveAll(Arrays.asList(s1, s2));
	}
	
}
