package org.ebong2.ownbustimetable.bus;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class BusInquirer {

    @Autowired
    protected BusInquirer(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    private final OkHttpClient okHttpClient;

}
