package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClaimingStairsTest {

    @Test
    public void should_claim() {
        ClaimingStairs claimingStairs = new ClaimingStairs();
        int way = claimingStairs.climbStairs(1500);
        System.out.println(way);
    }
}