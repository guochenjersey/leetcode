package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseScheduleTest {

  @Test
  public void should_be_able_to_complete() {
    int[][] pre = {{0, 1}};
    CourseSchedule courseSchedule = new CourseSchedule();
    courseSchedule.canFinish(2, pre);
  }
}
