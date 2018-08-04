package org.ebong2.ownbustimetable.bus;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class BusInquirer {
    @Value("${welcome.message}")
    @Getter
    private String message;

    @Autowired
    private BusInquirer(OkHttpClient okHttpClient,
                        @Qualifier(BusEndpointConfiguration.Region.GYEONGGI) HttpUrl.Builder builder) {
        this.okHttpClient = okHttpClient;
        this.builder = builder;
    }

    @PostConstruct
    public void init() {
        System.out.println(message);
    }

    private final OkHttpClient okHttpClient;
    private final HttpUrl.Builder builder;

}
