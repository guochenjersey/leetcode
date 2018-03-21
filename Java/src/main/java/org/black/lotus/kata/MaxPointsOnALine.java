package org.black.lotus.kata;

import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;

import java.math.BigInteger;

/**
 *
 * TODO
 * */
@NotAccepted
@NoIdeaOrBadIdeaInitially
@LintCode
@Medium
public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int maxNumber = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                int yDiff = (points[j].y - points[i].y);
                int xdiff = (points[j].x - points[i].x);
                while ((xdiff == 0 && yDiff == 0)) {
                    ++j;
                    yDiff = (points[j].y - points[i].y);
                    xdiff = (points[j].x - points[i].x);
                }

                int s = j - i + 1;
                int k = j + 1;
                while (k < points.length) {
                   int y1Diff = (points[k].y - points[j].y);
                   int x1diff = (points[k].x - points[j].x);
                    BigInteger xY1 = new BigInteger(String.valueOf(xdiff)).multiply(new BigInteger(String.valueOf(y1Diff)));
                    BigInteger x1Y = new BigInteger(String.valueOf(x1diff)).multiply(new BigInteger(String.valueOf(yDiff)));

                    if (xY1.compareTo(x1Y) == 0) {
                        System.out.println(points[i].x + " " + points[i].y);
                        System.out.println(points[j].x + " " + points[j].y);
                        System.out.println(points[k].x + " " + points[k].y);
                        ++s;
                    }
                    ++k;
                }

                maxNumber = Math.max(s, maxNumber);
                System.out.println("####################" + maxNumber);
            }
        }

        return maxNumber;
    }
}
