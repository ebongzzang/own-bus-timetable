package org.ebong2.ownbustimetable.collector;

import org.springframework.context.annotation.Configuration;

@Configuration
//TODO: composition?
public class BusArrivalInfoScheduleConfigurer extends ArrivalInfoScheduleConfigurer {
    protected BusArrivalInfoScheduleConfigurer(ArrivalInfoAccumulator accumulator) {
        super(accumulator);
    }
}
