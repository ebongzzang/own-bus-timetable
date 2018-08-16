package org.ebong2.ownbustimetable.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * 도착 정보 데이터 덤프 스케쥴링 설정
 */
@Configuration
public class ArrivalInfoScheduleConfigurer implements SchedulingConfigurer {

    protected final List<ArrivalInfoAccumulator> accumulator;

    @Autowired
    protected ArrivalInfoScheduleConfigurer(List<ArrivalInfoAccumulator> accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        for (ArrivalInfoAccumulator acc : accumulator) {
            taskRegistrar.addTriggerTask(
                    acc::put, triggerContext -> {
                        Instant nextTriggerTime = Instant.now().plus(acc.getInterval(), SECONDS);
                        return Date.from(nextTriggerTime);
                    });
        }
    }
}
