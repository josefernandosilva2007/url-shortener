package com.jfernando.url_shortener;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Base62UrlShortenerTest {
    @Test
    void shouldReturn13WhenId65(){
        Base62UrlShortener shortUrl = new Base62UrlShortener();
        String result = shortUrl.encode(65L);
        Assertions.assertEquals("13",result);
    }

    @Test
    void shouldReturn65WhenStringIs13(){
        Base62UrlShortener id = new Base62UrlShortener();
        Long decode = id.decode("13");
        Assertions.assertEquals(65L, decode);
    }


}
