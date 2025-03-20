package com.victorbrandao.url_shortener.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victorbrandao.url_shortener.entities.ShortUrl;
import com.victorbrandao.url_shortener.repositories.ShortUrlRepository;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

	@Autowired
	private ShortUrlRepository shortUrlRepository;

	@Override
	public void run(String... args) throws Exception {
		ShortUrl s1 = new ShortUrl(null, "Teste 1", "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test", "https://youtu.be/M4R_XUSTCcc");
		ShortUrl s2 = new ShortUrl(null, "Teste 2", "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test", "https://youtu.be/M4R_XUSTCcc");
		
		shortUrlRepository.saveAll(Arrays.asList(s1, s2));
	}
	
}
