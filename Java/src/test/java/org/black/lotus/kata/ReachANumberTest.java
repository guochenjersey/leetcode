package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReachANumberTest {

    @Test
    public void should_find_min_steps() {
        int target = 1;
        ReachANumber reachANumber = new ReachANumber();
        int res = reachANumber.reachNumber(target);
        assertEquals(1, res);
    }
}