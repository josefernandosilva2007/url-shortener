package com.jfernando.url_shortener;

public interface UrlShortener {
    String encode(Long id);
    Long decode(String shortUrl);
}
