package org.black.lotus.kata;

import java.util.Comparator;
import java.util.List;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Solution;

/**
 * Description 中文 English Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * <p>Have you met this question in a real interview? Example Example1
 *
 * <p>Input: intervals = [(0,30),(5,10),(15,20)] Output: false Explanation: (0,30), (5,10) and
 * (0,30),(15,20) will conflict Example2
 *
 * <p>Input: intervals = [(5,8),(9,15)] Output: true Explanation: Two times will not conflict
 */
@LintCode
@Facebook
@Easy
@FirstRound
public class MeetingRoom {

  @Solution("36%")
  public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) {
      return true;
    }

    intervals.sort(Comparator.comparingInt(i -> i.start));
    for (int i = 0; i < intervals.size(); ++i) {
      if (i + 1 < intervals.size()) {
        if (intervals.get(i).end > intervals.get(i + 1).start) {
          return false;
        }
      }
    }

    return true;
  }
}
