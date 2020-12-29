package ru.stqa.pft.soap;


import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("92.38.68.110");
        assertTrue(ipLocation.contains("RUS"));
    }

    @Test
    public void testInvalidIp() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("92.38.68.xxx");
        assertTrue(ipLocation.contains("US"));
    }
}

