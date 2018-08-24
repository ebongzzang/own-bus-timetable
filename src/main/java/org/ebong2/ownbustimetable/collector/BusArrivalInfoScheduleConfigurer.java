package org.ebong2.ownbustimetable.collector;

import org.springframework.context.annotation.Configuration;

@Configuration
//TODO: composition?
public class BusArrivalInfoScheduleConfigurer implements ArrivalInfoAccumulator {
    @Override
    public void put() {
    }

    @Override
    public Integer getInterval() {
        return null;
    }
}
