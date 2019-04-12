package org.black.lotus.kata;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KClosestPointsToOriginTest {

    @Test
    public void should_find_k_closest_point() {
        int[][] points = {{1, 3}, {-2, 2}};
        KClosestPointsToOrigin kPoints = new KClosestPointsToOrigin();
        int[][] res = kPoints.kClosest(points, 1);
        int[][] expectedRes = {{-2, 2}};
        Assert.assertArrayEquals(expectedRes, res);

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res2 = kPoints.kClosest(points2, 2);
        int[][] exptect2 = {{3, 3}, {-2, 4}};
        Assert.assertArrayEquals(exptect2, res2);
    }
}