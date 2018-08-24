package org.ebong2.ownbustimetable.bus;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.apache.livy.LivyClient;
import org.apache.livy.LivyClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final OkHttpClient okHttpClient;


    @Autowired
    public BusEndpointConfiguration( OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Primary
    @Bean
    @Qualifier(Region.GYEONGGI)
    public BusRequestCallBuilder gyeonggiClient() {
        return new BusRequestCallBuilder(okHttpClient,"www.gbis.go.kr/gbis2014/schBusAPI.action");
    }

    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        return objectMapper;
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
