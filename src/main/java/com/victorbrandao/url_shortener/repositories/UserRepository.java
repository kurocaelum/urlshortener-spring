package com.victorbrandao.url_shortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorbrandao.url_shortener.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
