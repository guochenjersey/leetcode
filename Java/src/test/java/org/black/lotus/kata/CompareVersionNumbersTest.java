package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompareVersionNumbersTest {

    @Test
    public void should_find_parts() {
        String s1 = "01";
        String s2 = "1";
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        int i = compareVersionNumbers.compareVersion(s1, s2);
        assertEquals(0, i);
    }

    @Test
    public void should_find_parts_2() {
        String s1 = "1.1";
        String s2 = "1.10";
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        int i = compareVersionNumbers.compareVersion(s1, s2);
        assertEquals(-1, i);
    }

    @Test
    public void should_find_parts_3() {
        String s1 = "1.0";
        String s2 = "1";
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        int i = compareVersionNumbers.compareVersion(s1, s2);
        assertEquals(0, i);
    }
}