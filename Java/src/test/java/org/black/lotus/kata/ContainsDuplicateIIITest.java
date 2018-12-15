package org.black.lotus.kata;

import org.junit.Test;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ContainsDuplicateIIITest {

    @Test
    public void should_find_contains_duplicate_iii() {
        int[] source = {1, 2, 3, 1};
        int k = 3, t = 0;
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        boolean res = containsDuplicateIII.containsNearbyAlmostDuplicate(source, k, t);
        assertTrue(res);

        int[] source1 = {1, 0, 1, 1};
        int k1 = 1, t1 = 2;
        boolean res1 = containsDuplicateIII.containsNearbyAlmostDuplicate(source1, k1, t1);
        assertTrue(res1);

        TreeSet<SampleTest> set = new TreeSet<>(Comparator.comparingInt(i -> i.i));

        SampleTest sample = new SampleTest(1);
        SampleTest sample1 = new SampleTest(2);
        SampleTest sample2 = new SampleTest(3);
        SampleTest sample3 = new SampleTest(4);

        set.add(sample);
        set.add(sample1);
        set.add(sample2);
        set.add(sample3);

        SortedSet<SampleTest> subSet = set.subSet(sample, sample2);
        assertEquals(2, subSet.size());

    }
}

class SampleTest {
    int i;

    SampleTest(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SampleTest that = (SampleTest) o;

        return i == that.i;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
