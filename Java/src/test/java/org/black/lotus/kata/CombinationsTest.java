package org.black.lotus.kata;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void should_find_all_combinations() {
        Combinations combinations = new Combinations();
        List<List<Integer>> res = combinations.combine(3, 2);
        res.forEach(l -> {l.forEach(System.out::print); System.out.println();});
    }
}