package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class LastPositionOfTargetTest {
  @Rule public Timeout globalTimeout = Timeout.seconds(2);

  private LastPositionOfTarget lastPositionOfTarget;

  @Before
  public void setup() {
    lastPositionOfTarget = new LastPositionOfTarget();
  }

  @Test
  public void should_handle_empty_array() {
    int[] nums = null;
    int result = lastPositionOfTarget.lastPosition(nums, 1);
    assertThat(-1, CoreMatchers.equalTo(result));

    nums = new int[0];
    result = lastPositionOfTarget.lastPosition(nums, 1);
    assertThat(-1, CoreMatchers.equalTo(result));
  }

  @Test
  public void should_able_to_find_last_pos() {
    int[] nums = {0, 1, 2, 3, 4, 5, 5, 5, 8, 9, 10};
    int result = lastPositionOfTarget.lastPosition(nums, 5);
    assertThat(7, CoreMatchers.equalTo(result));
  }
}
