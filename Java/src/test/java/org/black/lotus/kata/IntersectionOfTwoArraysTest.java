package org.black.lotus.kata;

import org.black.lotus.marker.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionOfTwoArraysTest {

    @Test
    public void should_find_intersection() {
        int[] source1 = {1, 2, 2, 1};
        int[] source2 = {2, 2};
        int[] expectedRes1 = {2};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        assertArrayEquals(expectedRes1, intersectionOfTwoArrays.intersection(source1, source2));
    }

    @Test
    public void should_find_intersection2() {
        int[] source1 = {4, 9, 5};
        int[] source2 = {9, 4, 9, 8, 4};

        int[] expectedRes = {4, 9};
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

        assertArrayEquals(expectedRes, intersection.intersection(source1, source2));
    }
}