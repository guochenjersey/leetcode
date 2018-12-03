package org.black.lotus.kata;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void should_find_all_combinations() {
        Combinations combinations = new Combinations();
        combinations.combine(3, 2);
    }

    @Test
    public void should_print_minus_within_20() {
        for(int i = 0; i < 100; ++i) {
            int n1 = RandomUtils.nextInt(10, 20);
            int n2 = RandomUtils.nextInt(1, 20);
            if (n1 >= n2) {
                System.out.println(String.format("%s - %s = ", n1, n2));
            } else {
                System.out.println(String.format("%s - %s = ", n2, n1));
            }
        }
    }
}