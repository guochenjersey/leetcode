package org.black.lotus.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FindKClosestElementsTest {

    @Test
    public void should_find_k_closest_elements() {
        int[] nums = {7, 8, 12, 34, 56};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(nums, 2, 10);
        List<Integer> expectedRes = Arrays.asList(8, 12);

        assertEquals(expectedRes, closestElements);
    }

    @Test
    public void should_find_k_closest_elements_2() {
        int[] nums = {7, 8, 12, 34, 56};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(nums, 2, 7);
        List<Integer> expectedRes = Arrays.asList(7, 8);

        assertEquals(expectedRes, closestElements);
    }

    @Test
    public void should_find_k_ele_3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(nums, 3, 10);
        List<Integer> expectedRes = Arrays.asList(7, 8, 10);

        assertEquals(expectedRes, closestElements);
    }

    @Test
    public void should_find_k_ele_4() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(nums, 3, 1);
        List<Integer> expectedRes = Arrays.asList(1, 2, 3);

        assertEquals(expectedRes, closestElements);
    }

    @Test
    public void should_find_k_ele_5() {
        int[] nums = {1, 2, 2, 3, 4, 5, 6, 7, 8, 10};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(nums, 3, 2);
        List<Integer> expectedRes = Arrays.asList(1, 2, 2);

        assertEquals(expectedRes, closestElements);
    }


    @Test
    public void should_find_k_ele_6() {
        int[] nums = {0,1,1,1,2,3,6,7,8,9};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(nums, 9, 4);
        List<Integer> expectedRes = Arrays.asList(0,1,1,1,2,3,6,7,8);

        assertEquals(expectedRes, closestElements);
    }

}