package com.jfernando.url_shortener;

import com.jfernando.url_shortener.exception.InvalidSlugException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Base62UrlShortenerTest {
    @Test
    void shouldReturn13WhenId65(){
        Base62UrlShortener shortUrl = new Base62UrlShortener();
        String result = shortUrl.encode(65L);
        Assertions.assertEquals("13",result);
    }

    @Test
    void shouldReturn65WhenStringIs13(){
        Base62UrlShortener shortUrl = new Base62UrlShortener();
        Long decode = shortUrl.decode("13");
        Assertions.assertEquals(65L, decode);
    }

    @Test
    void shouldReturnInvalidSlugException(){
        Base62UrlShortener shortUrl = new Base62UrlShortener();
        Assertions.assertThrows(InvalidSlugException.class, () -> shortUrl.decode("@"));
    }

}
