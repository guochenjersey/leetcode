package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FirstRound
@LintCode
@Medium
public class LargestNumber {
    public String largestNumber(int[] nums) {

        List<Integer> sortedList = Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s2 + s1).compareTo(s1 + s2);
        }).collect(Collectors.toList());

        StringBuilder res = new StringBuilder();

        for (Integer i : sortedList) {
            res.append(i);
        }
        if (res.toString().charAt(0) == '0') {
            return "0";
        }

        return res.toString();
    }
}
