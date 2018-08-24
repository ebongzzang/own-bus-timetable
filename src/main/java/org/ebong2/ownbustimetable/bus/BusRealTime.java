package org.ebong2.ownbustimetable.bus;

import javax.persistence.Entity;

@Entity
public class BusRealTime {
    private int routeNum;
    private int busPosition;
    private boolean lowBusYn;
    private int toStationId;
    private int fromStationId;
    private String busNo;


}
