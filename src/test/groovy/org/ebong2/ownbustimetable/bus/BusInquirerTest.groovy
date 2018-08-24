package org.ebong2.ownbustimetable.bus

import okhttp3.OkHttpClient
import spock.lang.Shared
import spock.lang.Specification

class BusInquirerTest extends Specification {

    @Shared
    BusInquirer busInquirer

    def setupSpec() {
        def builder = new BusRequestCallBuilder(new OkHttpClient(), "http://www.gbis.go.kr/gbis2014/schBusAPI.action")
        busInquirer = new BusInquirer(builder, new BusEndpointConfiguration().objectMapper())
    }

    def testRetrieveBusRouteInfoById() {
        given:
            def routeId = 218000001
        when:
            busInquirer.retrieveBusRouteInfoById(routeId)
        then:
          noExceptionThrown()
    }
}
