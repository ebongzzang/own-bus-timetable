package org.ebong2.ownbustimetable.bus;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusEndpointConfiguration {
    public static class Region {
        public static final String GYEONGGI = "gyeonggi";
        public static final String Seoul = "Seoul";
    }

    @Bean
    @Qualifier(Region.GYEONGGI)
    public HttpUrl.Builder geyonggiClient(OkHttpClient httpClient) {
        return new HttpUrl.Builder()
                .host("http://www.gbis.go.kr")
                .addPathSegment("gbis2014")
                .addPathSegment("schBus.action");
    }

}
