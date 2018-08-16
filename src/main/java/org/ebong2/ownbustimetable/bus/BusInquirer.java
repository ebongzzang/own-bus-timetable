package org.ebong2.ownbustimetable.bus;

import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BusInquirer {

    private final OkHttpClient okHttpClient;

    @Autowired
    protected BusInquirer(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Autowired
    public void fire(HttpUrl.Builder builder) {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("cmd", "searchRouteJson")
                .addFormDataPart("routeId", "241328003")
                .build();

    }



}
