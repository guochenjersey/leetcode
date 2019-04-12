package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

 (Here, the distance between two points on a plane is the Euclidean distance.)

 You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



 Example 1:

 Input: points = [[1,3],[-2,2]], K = 1
 Output: [[-2,2]]
 Explanation:
 The distance between (1, 3) and the origin is sqrt(10).
 The distance between (-2, 2) and the origin is sqrt(8).
 Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 Example 2:

 Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 Output: [[3,3],[-2,4]]
 (The answer [[-2,4],[3,3]] would also be accepted.)
 Note:

 1 <= K <= points.length <= 10000
 -10000 < points[i][0] < 10000
 -10000 < points[i][1] < 10000
 *
 * */
@LeetCode
@Medium
@Accepted("only beat 5%")
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Distance> distances = new PriorityQueue<>((o1, o2) -> o1.distance.subtract(o2.distance).intValue());
        int[][] res = new int[K][2];
        for (int i = 0; i < points.length; ++i) {
            Distance d = new Distance();
            BigInteger x = new BigInteger(String.valueOf(points[i][0])).multiply(new BigInteger(String.valueOf(points[i][0])));
            BigInteger y = new BigInteger(String.valueOf(points[i][1])).multiply(new BigInteger(String.valueOf(points[i][1])));
            int[] p = new int[2];
            p[0] = points[i][0];
            p[1] = points[i][1];
            d.point = p;
            d.distance = x.add(y);
            distances.add(d);
        }

        for (int i = 0; i < K; ++i) {
            Distance d = distances.poll();
            res[i] = d.point;
        }

        return res;
    }

    class Distance {
        public BigInteger distance;
        public int[] point;
    }
}
