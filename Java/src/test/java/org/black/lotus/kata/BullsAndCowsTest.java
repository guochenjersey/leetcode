package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class BullsAndCowsTest {

    @Test
    public void count_bull_and_cow() {
        BullsAndCows bullsAndCows = new BullsAndCows();
        assertEquals("1A3B", bullsAndCows.getHintSlow("1807", "7810"));
        assertEquals("1A1B", bullsAndCows.getHintSlow("1123", "0111"));
        assertEquals("0A4B", bullsAndCows.getHintSlow("1122", "2211"));
        assertEquals("1A2B", bullsAndCows.getHintSlow("011", "110"));
        assertEquals("0A1B", bullsAndCows.getHintSlow("1122", "0001"));
    }
}