package org.ebong2.ownbustimetable.collector;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.sql.Date;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

abstract class ArrivalInfoScheduleConfigurer implements SchedulingConfigurer {
    protected ArrivalInfoAccumulator accumulator;

    protected ArrivalInfoScheduleConfigurer(ArrivalInfoAccumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> accumulator.put(), triggerContext -> {
                    Instant nextTriggerTime = Instant.now().plus(accumulator.getInterval(), SECONDS);
                    return Date.from(nextTriggerTime);
                }
        );
    }
}
