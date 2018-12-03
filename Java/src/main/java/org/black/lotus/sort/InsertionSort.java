package org.black.lotus.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void sort(int[] source) {
        if (source == null || source.length <= 1) {
            return;
        }

        for (int i = 1; i < source.length; ++i) {
            int val = source[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (source[j] > val) {
                    source[j + 1] = source[j];
                } else {
                    break;
                }
            }
            source[j+1] = val;
        }
    }

    public static void main(String... args) {
        Random random = new Random(System.currentTimeMillis());
        int[] source1 = new int[1000000];
        int[] source2 = new int[1000000];
        for (int i = 0; i < 1000000; ++i) {
            int val = random.nextInt();
            source1[i] = val;
            source2[i] = val;
        }

        Instant bubbleStart = Instant.now();
        BubbleSort.sort(source1);
        System.out.println(Duration.between(bubbleStart, Instant.now()).toMillis());

        Instant insertionStart = Instant.now();
        sort(source2);
        System.out.println(Duration.between(insertionStart, Instant.now()).toMillis());
    }
}
