package org.ebong2.ownbustimetable.bus;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class BusInquirer {
    @Value("${welcome.message}")
    @Getter
    private String message;

    @PostConstruct
    public void init() {
        System.out.println(message);
    }
}
