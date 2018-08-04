package org.ebong2.ownbustimetable.bus;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
class BusRouteInfo {
    private Integer districtCd;
    private String regionName;
    private String routeDestName;
    private Integer routeId;
    private String routeName;
    private Integer routeTypeCd;
    private String routeTypeName;
    private Integer staOrder;
    private Boolean updownNum;

}
