package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class MajorityNumberTest {

  private MajorityNumber majorityNumber;

  @Before
  public void setup() {
    majorityNumber = new MajorityNumber();
  }

  @Test
  public void should_find_majority_number() {
    int[] nums = {1, 1, 1, 1, 2, 2, 2};
    int i = majorityNumber.majorityNumber(Arrays.stream(nums).boxed()
        .collect(Collectors.toList()));

    assertEquals(1, i);

  }
}