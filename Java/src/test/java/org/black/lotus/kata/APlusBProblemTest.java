package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class APlusBProblemTest {

    @Test
    public void should_find_a_plus_b() {
        APlusBProblem aPlusBProblem = new APlusBProblem();
        int res = aPlusBProblem.aplusb(5, 17);
        assertEquals(22, res);
    }
}