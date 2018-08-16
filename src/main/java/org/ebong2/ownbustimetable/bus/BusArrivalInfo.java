package org.ebong2.ownbustimetable.bus;

import lombok.Data;

import javax.persistence.Entity;

/**
 * 특정 정류장에서 운행하는 모든 버스의 도착 예상 시간과 메타데이터를 표현하는 엔티티
 */
@Data
@Entity
public class BusArrivalInfo {

    private String stationId;

    private String routeId;

    private String remainSeatCnt1;

    private String delayYn1;

    private String delayYn2;

    private String endBus1;

    private String remainSeatCnt2;

    private String endBus2;

    private String runBusFlag;

    private String lowPlate1;

    private String drvEnd;

    private String plateType1;

    private String routeTypeCd;

    private String lowPlate2;

    private String plateType2;

    private String turnSeq;

    private String plateNo2;

    private String plateNo1;

    private String stationNm1;

    private String stationNm2;

    private String lastTime;

    private String locationNo2;

    private String locationNo1;

    private String routeDestName;

    private String vehId2;

    private String predictTime2;

    private String firstTime;

    private String flag;

    private String vehId1;

    private String crowded1;

    private String predictTime1;

    private String crowded2;

    private String density1;

    private String density2;

    private String staOrder;

    private String routeName;
}
