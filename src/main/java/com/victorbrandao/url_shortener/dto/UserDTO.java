package com.victorbrandao.url_shortener.dto;

import java.util.List;

import com.victorbrandao.url_shortener.entities.ShortUrl;

public record UserDTO(long id, String username, List<ShortUrl> urls) {}
