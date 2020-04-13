package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] toSort, int[] template) {
        if (template == null || template.length == 0) {
            Arrays.sort(toSort);
            return toSort;
        }
        if (toSort == null || toSort.length == 0) {
            return toSort;
        }

        Map<Integer, Integer> toSortCounter = new HashMap<>();

        Map<Integer, Integer> templatePos = new HashMap<>();
        for (int i = 0; i < template.length; ++i) {
            templatePos.put(template[i], i);
        }
        List<Integer> notInTemplate = new ArrayList<>();
        Set<Integer> keySet = templatePos.keySet();
        for (int i = 0; i < toSort.length; ++i) {
            if (!keySet.contains(toSort[i])) {
                notInTemplate.add(toSort[i]);
            } else {
                toSortCounter.putIfAbsent(toSort[i], 0);
                toSortCounter.compute(toSort[i], (k, v) -> v + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < template.length; ++i) {
            Integer repeatTimes = toSortCounter.get(template[i]);
            while(repeatTimes > 0) {
                res.add(template[i]);
                --repeatTimes;
            }
        }

        notInTemplate.sort(Comparator.comparingInt(i -> i));
        res.addAll(notInTemplate);

        return res.stream().mapToInt(i->i).toArray();
    }
}
