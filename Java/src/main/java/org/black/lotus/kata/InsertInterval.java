package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO
 * */
@FirstRound
@Easy
@LintCode
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            results.add(newInterval);
            return results;
        }
        return null;
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
