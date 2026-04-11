package com.jfernando.url_shortener.controller;


import com.jfernando.url_shortener.dto.UrlRequest;
import com.jfernando.url_shortener.dto.UrlResponse;
import com.jfernando.url_shortener.entity.Url;
import com.jfernando.url_shortener.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shortUrl(@Valid @RequestBody UrlRequest request){
        Url originalUrl = urlService.shortenUrl(request.originalUrl());
        String shortUrl = "http://localhost:8080/" + originalUrl.getShortUrl();
        return ResponseEntity.status(HttpStatus.OK).body(new UrlResponse(shortUrl));
    }


}
