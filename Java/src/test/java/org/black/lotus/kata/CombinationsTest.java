package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void should_find_all_combinations() {
        Combinations combinations = new Combinations();
        combinations.combine(3, 2);
    }
}