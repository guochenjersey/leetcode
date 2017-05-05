package org.black.lotus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Kata554Test {

    @Test
    public void testKata554() {
        Kata554 kata554 = new Kata554();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));


        assertEquals(2, kata554.leastBricks(wall));
    }

    @Test
    public void testKata554Memory() {
        Kata554 kata554 = new Kata554();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(100000000));
        wall.add(Arrays.asList(100000000));
        wall.add(Arrays.asList(100000000));

        assertEquals(3, kata554.leastBricks(wall));
    }
}