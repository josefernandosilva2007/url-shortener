package com.jfernando.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record UrlRequest(
        @NotBlank(message = "A url não pode estar vazia")
        @URL(message = "Formato de URL inválido")
        String originalUrl
)
{}
