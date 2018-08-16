package org.ebong2.ownbustimetable.collector;

import org.apache.livy.LivyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class BusArrivalInfoAccumulator implements ArrivalInfoAccumulator {

    private final LivyClient livyClient;
    private final Integer interval;

    @Autowired
    public BusArrivalInfoAccumulator(LivyClient livyClient,
                                     @Value("${collector.interval.bus:50}") Integer interval) {
        this.livyClient = livyClient;
        this.interval = interval;
    }

    @Override
    public void put() {

    }

    @Override
    public Integer getInterval() {
        return this.interval;
    }
}
