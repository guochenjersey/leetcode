package org.black.lotus.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void should_combinate_sum() {
        int[] source = {2, 3, 6, 7};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> res = combinationSum.combinationSum(source, 7);
        assertEquals(res.size(), 2);
    }
}