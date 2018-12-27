package org.black.lotus.kata;

import org.black.lotus.marker.BinarySearch;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@FirstRound
@Easy
@BinarySearch
public class PeakIndexInAMountain {

    public int peakIndexInMountainArray(int[] source) {
        int start = 0;
        int end = source.length - 1;
        while (start + 1 < end) {
            int mid = (end + start) >> 1;
            if (source[mid] > source[mid + 1]
                    && source[mid] > source[mid -1]) {
                return mid;
            }

            if (source[mid] < source[mid + 1]
                    && source[mid - 1] < source[mid]) {
                start = mid;
            }

            if (source[mid] > source[mid + 1]
                    && source[mid - 1] > source[mid]) {
                end = mid;
            }
        }

        return -1;
    }
}
