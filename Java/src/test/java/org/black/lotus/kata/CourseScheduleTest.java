package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {

    @Test
    public void should_be_able_to_complete() {
        int[][] pre = {{0, 1}};
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.canFinish(2, pre);
    }
}