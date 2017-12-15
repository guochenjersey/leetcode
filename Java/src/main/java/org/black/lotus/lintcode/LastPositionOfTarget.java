package org.black.lotus.lintcode;

public class LastPositionOfTarget {

    public int lastPosition(int[] source, int target) {
        if (source == null || source.length == 0
                || target < source[0] || target > source[source.length - 1]) {
            return -1;
        }

        if (target == source[source.length - 1]) {
            return source.length - 1;
        }

        if (target == source[0]) {
            return 0;
        }

        int lowerBoundIndex = 0;
        int upperBoundIndex = source.length - 1;
        int lastFoundPos = -1;
        while (lowerBoundIndex < upperBoundIndex) {
            int middle = findMiddle(lowerBoundIndex, upperBoundIndex);
            if (source[middle] == target) {
                lastFoundPos = middle;
                lowerBoundIndex = middle;
            } else if (target > source[lowerBoundIndex] && target < source[middle] && (middle - lowerBoundIndex > 1)) {
                upperBoundIndex = middle;
            } else if (target < source[upperBoundIndex] && target > source[middle] && (upperBoundIndex - middle) > 1) {
                lowerBoundIndex = middle;
            } else {
                break;
            }
        }

        return lastFoundPos;
    }

    private int findMiddle(int lowerBoundIndex, int upperBoundIndex) {
        return ((upperBoundIndex - lowerBoundIndex) / 2 ) + lowerBoundIndex;
    }

    public static void main(String... args) {
        int[] source = {1,2,4,5,5,6,6,6};
        LastPositionOfTarget lastPositionOfTarget = new LastPositionOfTarget();
        int lastFoundPos = lastPositionOfTarget.lastPosition(source, 1000);
        System.out.println(lastFoundPos);
    }
}
