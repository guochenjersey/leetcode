package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MeetingRoomIITest {

  @Test
  public void should_find_meeting_room() {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(0, 30));
    intervals.add(new Interval(5, 10));
    intervals.add(new Interval(15, 20));

    List<Interval> intervals2 = new ArrayList<>();
    intervals2.add(new Interval(2, 7));

    List<Interval> interval3 = new ArrayList<>();
    interval3.add(new Interval(19, 797));
    interval3.add(new Interval(65, 424));
    interval3.add(new Interval(136, 897));
    interval3.add(new Interval(165, 221));
    interval3.add(new Interval(259, 722));
    interval3.add(new Interval(314, 807));
    interval3.add(new Interval(351, 507));
    interval3.add(new Interval(387, 722));

    MeetingRoomII meetingRoomII = new MeetingRoomII();

    assertEquals(2, meetingRoomII.minMeetingRooms(intervals));
    assertEquals(0, meetingRoomII.minMeetingRooms(null));
    assertEquals(1, meetingRoomII.minMeetingRooms(intervals2));
    assertEquals(7, meetingRoomII.minMeetingRooms(interval3));
  }
}
