package org.ebong2.ownbustimetable.bus;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class BusInquirer {

    private final BusRequestCallBuilder urlBuilder;
    private final ObjectMapper  objectMapper;


    @Autowired
    protected BusInquirer(@Qualifier(BusEndpointConfiguration.Region.GYEONGGI) BusRequestCallBuilder urlBuilder, ObjectMapper objectMapper) {
        this.urlBuilder = urlBuilder;
        this.objectMapper = objectMapper;
    }


    public void retrieveCurrentBusPosition() throws IOException {

        Call command = urlBuilder
                .addQueryParameter("cmd","searchBusStationJson")
                .addQueryParameter("stationId", "218000179")
                .build();

        Response response = command.execute();

        String jsonData = response.body().string();

        JsonNode jsonNode = objectMapper.readTree(jsonData);
        
    }

    public BusRealTime retrieveBusRouteInfoById(int id) throws IOException  {
        Call command = urlBuilder
                .addQueryParameter("cmd","searchRouteJson")
                .addQueryParameter("routeId", String.valueOf(id))
                .build();

        //TODO refactor
        BusRealTime busArrivalInfo = null;

        try(Response response = command.execute()) {
            String jsonData = response.body().string();

            JsonNode jsonTree = objectMapper.readTree(jsonData);

            boolean found = jsonTree.path("result").path("realTime").path("list").isArray()
            log.debug(busArrivalInfo.toString());
        }

        return busArrivalInfo;
    }



}
