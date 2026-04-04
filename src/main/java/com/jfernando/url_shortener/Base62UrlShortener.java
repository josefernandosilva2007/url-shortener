package com.jfernando.url_shortener;

public class Base62UrlShortener implements UrlShortener{

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Override
    public String encode(Long id) {
        if(id == 0) return String.valueOf(ALPHABET.charAt(0));
        StringBuilder url = new StringBuilder();
        while(id>0){
            long rem = id%ALPHABET.length();
            id = id/ALPHABET.length();
            url.append(ALPHABET.charAt(Math.toIntExact(rem)));
        }
        return url.reverse().toString();
    }

    @Override
    public Long decode(String shortUrl) {
        long result = 0;
        for(int i = 0; i < shortUrl.length(); i++){
            int index = ALPHABET.indexOf(shortUrl.charAt(i));
            result = (result * ALPHABET.length()) + index;
        }
        return result;
    }
}
