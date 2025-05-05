package com.victorbrandao.url_shortener.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorbrandao.url_shortener.dto.AuthenticationDTO;
import com.victorbrandao.url_shortener.dto.LoginResponseDTO;
import com.victorbrandao.url_shortener.entities.User;
import com.victorbrandao.url_shortener.repositories.UserRepository;
import com.victorbrandao.url_shortener.services.TokenService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((User) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("register")
	public ResponseEntity register(@RequestBody @Valid AuthenticationDTO data) {
		if(this.repository.findByUsername(data.username()) != null) 
			return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User();
		newUser.setUsername(data.username());
		newUser.setPassword(encryptedPassword);
		
		this.repository.save(newUser);
//		TODO retornar response.created()?
		return ResponseEntity.ok().build();
	}
	
}
