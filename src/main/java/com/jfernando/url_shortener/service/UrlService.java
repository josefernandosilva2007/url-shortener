package com.jfernando.url_shortener.service;

import com.jfernando.url_shortener.Base62UrlShortener;
import com.jfernando.url_shortener.entity.Url;
import com.jfernando.url_shortener.exception.ResourceNotFound;
import com.jfernando.url_shortener.repository.UrlRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository repo;
    private final Base62UrlShortener shorten;

    @Transactional
    public Url shortenUrl(String longUrl) {
        return repo.findByOriginalUrl(longUrl).orElseGet(() -> {
            Url url = new Url();
            url.setOriginalUrl(longUrl);

            repo.save(url);

            String encode = shorten.encode(url.getId());
            url.setShortUrl(encode);

            return repo.save(url);
        });
    }

    public Url originalUrl(String slug){
        Long decode = shorten.decode(slug);
        return repo.findById(decode).orElseThrow(() -> new ResourceNotFound("Url not found"));
    }
}
