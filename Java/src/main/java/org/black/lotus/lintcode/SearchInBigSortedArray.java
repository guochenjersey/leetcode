package org.black.lotus.lintcode;

import org.black.lotus.misc.ArrayReader;

public class SearchInBigSortedArray {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midNumber = reader.get(mid);
            if (midNumber == target) {
                end = mid;
            } else if (target > midNumber && target <= reader.get(end)) {
                start = mid;
            } else if (target < midNumber && target >= reader.get(start)) {
                end = mid;
            }
        }


        if (reader.get(start) == target) {
            return start;
        }

        if (reader.get(end) == target) {
            return end;
        }

        return -1;
    }

    public static void main(String... args) {
        ArrayReader arrayReader = new ArrayReader();
        SearchInBigSortedArray searchInBigSortedArray = new SearchInBigSortedArray();
        int foundIndex = searchInBigSortedArray.searchBigSortedArray(arrayReader, 4);
        System.out.println(foundIndex);
    }
}
