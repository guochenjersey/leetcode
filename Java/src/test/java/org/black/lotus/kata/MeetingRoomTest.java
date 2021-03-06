package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MeetingRoomTest {

  @Test
  public void should_find_meeting_room() {
    Interval zeroTo30 = new Interval(0, 30);
    Interval fiveTo10 = new Interval(5, 10);
    List<Interval> intervals = new ArrayList<>();
    intervals.add(zeroTo30);
    intervals.add(fiveTo10);

    MeetingRoom meetingRoom = new MeetingRoom();
    assertFalse(meetingRoom.canAttendMeetings(intervals));
  }
}
