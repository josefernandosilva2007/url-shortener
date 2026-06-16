package com.jfernando.url_shortener.controller;


import com.jfernando.url_shortener.dto.UrlRequest;
import com.jfernando.url_shortener.dto.UrlResponse;
import com.jfernando.url_shortener.entity.Url;
import com.jfernando.url_shortener.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @Value("${app.base-url}")
    private String baseUrl;

    @PostMapping("/v1/shorten")
    public ResponseEntity<UrlResponse> createShortUrl(@Valid @RequestBody UrlRequest request){
        Url originalUrl = urlService.shortenUrl(request.originalUrl());
        String shortUrl = baseUrl + originalUrl.getShortUrl();
        return ResponseEntity.status(HttpStatus.CREATED).body(new UrlResponse(shortUrl));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String slug){
        Url url = urlService.originalUrl(slug);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getOriginalUrl())).build();
    }


}
