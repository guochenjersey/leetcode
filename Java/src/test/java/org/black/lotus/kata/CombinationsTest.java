package org.black.lotus.kata;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.TreeSet;

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

    @Test
    public void should_test_tree_set() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(3);
        treeSet.add(10);
        Integer ceiling = treeSet.ceiling(9);
        Integer floor = treeSet.floor(5);
        System.out.println(ceiling);
        System.out.println(floor);
    }
}