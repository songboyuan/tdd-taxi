package com.jiker.keju;

import org.junit.Test;
import static org.junit.Assert.*;

public class DistanceAndWaitParserTest {

    @Test
    public void base_case_1km_0min() {
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        int distance = parser.getDistance("1公里, 等待0分钟");
        assertEquals(distance, 1);
        int waitTime = parser.getWaitTime("1公里, 等待0分钟");
        assertEquals(waitTime, 0);
    }

    @Test
    public void base_case_2km_3min() {
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        int distance = parser.getDistance("2公里, 等待3分钟");
        assertEquals(distance, 2);
        int waitTime = parser.getWaitTime("2公里, 等待3分");
        assertEquals(waitTime, 3);
    }

    @Test
    public void bad_case_no_km() {
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        int distance = parser.getDistance("等待3分钟");
        assertEquals(distance, 0);
        int waitTime = parser.getWaitTime("等待3分");
        assertEquals(waitTime, 0);
    }

    @Test
    public void bad_case_has_km_no_wait() {
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        int distance = parser.getDistance("0km,无等待");
        assertEquals(distance, 0);
        int waitTime = parser.getWaitTime("1km,无等待");
        assertEquals(waitTime, 0);
    }

    @Test
    public void bad_case_empty_string() {
        DistanceAndWaitParser parser = new DistanceAndWaitParser();
        int distance = parser.getDistance("");
        assertEquals(distance, 0);
        int waitTime = parser.getWaitTime("");
        assertEquals(waitTime, 0);
    }
}

