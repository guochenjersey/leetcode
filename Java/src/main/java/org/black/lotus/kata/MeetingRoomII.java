package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 Have you met this question in a real interview?
 Example
 Example1

 Input: intervals = [(0,30),(5,10),(15,20)]
 Output: 2
 Explanation:
 We need two meeting rooms
 room1: (0,30)
 room2: (5,10),(15,20)
 Example2

 Input: intervals = [(2,7)]
 Output: 1
 Explanation:
 Only need one meeting room
 * */
@LintCode
@Facebook
@Medium
@Accepted
public class MeetingRoomII {

    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return 0;
        intervals.sort( Comparator.comparingInt(i2 -> i2.start));
        // 用堆来管理房间的结束时间
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++){
            // 如果当前时间段的开始时间大于最早结束的时间，则可以更新这个最早的结束时间为当前时间段的结束时间，
            // 如果小于的话，就加入一个新的结束时间，表示新的房间
            if(intervals.get(i).start >= endTimes.peek()){
                endTimes.poll();
            }
            endTimes.offer(intervals.get(i).end);
        }
        // 有多少结束时间就有多少房间
        return endTimes.size();
    }
}
