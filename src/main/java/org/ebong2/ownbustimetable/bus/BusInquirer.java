package org.ebong2.ownbustimetable.bus;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class BusInquirer {

    private final HttpUrl.Builder urlBuilder;

    private final OkHttpClient okHttpClient;


    @Autowired
    protected BusInquirer(@Qualifier(BusEndpointConfiguration.Region.GYEONGGI) HttpUrl.Builder urlBuilder, OkHttpClient okHttpClient) {
        this.urlBuilder = urlBuilder;
        this.okHttpClient = okHttpClient;
    }

    @Autowired
    public void fire() throws IOException {
        HttpUrl  url = urlBuilder
                .addQueryParameter("cmd","searchBusStationJson")
                .addQueryParameter("stationId", "218000179")
                .build();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
         Response response = okHttpClient.newCall(request).execute();

        String jsonData = response.body().string();
        ObjectMapper  objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonData);

       log.debug( jsonNode.toString());


    }



}
