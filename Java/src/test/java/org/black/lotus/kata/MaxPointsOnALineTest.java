package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxPointsOnALineTest {

    @Test
    public void should_find_max_points() {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        Point[] points = PointHelper.from();

        maxPointsOnALine.maxPoints(points);
    }
}

class PointHelper {

    public static Point[] from() {
        int[][] points = {{0, 9}, {138, 429}, {115, 359}, {115, 359}, {-30, -102}, {230, 709}, {-150, -686}, {-135, -613},
                {-60, -248}, {-161, -481}, {207, 639}, {23, 79}, {-230, -691}, {-115, -341}, {92, 289},
                {60, 336}, {-105, -467}, {135, 701}, {-90, -394}, {-184, -551}, {150, 774}};
        Point[] res = new Point[points.length];

        for (int i = 0; i < points.length; ++i) {
            Point p = new Point(points[i][0], points[i][1]);
            res[i] = p;
        }

        return res;
    }
}