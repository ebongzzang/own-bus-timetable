package org.ebong2.ownbustimetable.bus;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.livy.LivyClient;
import org.apache.livy.LivyClientBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URI;


/**
 * 버스 조회시
 */
@Configuration
public class BusEndpointConfiguration {
    public static class Region {
        public static final String GYEONGGI = "gyeonggi";
        public static final String Seoul = "Seoul";
    }

    @Primary
    @Bean
    @Qualifier(Region.GYEONGGI)
    public HttpUrl.Builder gyeonggiClient() {
        return new HttpUrl.Builder()
                .host("http://www.gbis.go.kr")
                .addPathSegment("gbis2014")
                .addPathSegment("schBusAPI.action");

    }


    @Primary
    @Bean
    public LivyClient livyClient(@Value("${livy.url}") String livyUrl) {
        LivyClient livyClient = null;

        try {
            livyClient = new LivyClientBuilder()
                    .setURI(new URI(livyUrl))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return livyClient;

    }
}
