package org.black.lotus.lintcode;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class MaxNumberInMountainSequenceTest {

    private MaxNumberInMountainSequence maxNumberInMountainSequence;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Before
    public void setup() {
        maxNumberInMountainSequence = new MaxNumberInMountainSequence();
    }

    @Test
    public void should_handle_descending_array() {
        int[] nums = {10, 9, 8, 7, 6};
        int result = maxNumberInMountainSequence.mountainSequence(nums);
        assertThat(result, CoreMatchers.equalTo(result));
    }

    @Test
    public void should_handle_ascending_array() {
        int[] nums = {1, 2, 3, 4};
        int result = maxNumberInMountainSequence.mountainSequence(nums);
        assertThat(4, CoreMatchers.equalTo(result));
    }

    @Test
    public void should_handle_odd_numbers_array() {
        int[] nums = {1, 3, 5, 7, 9, 11, 9};
        int result = maxNumberInMountainSequence.mountainSequence(nums);
        assertThat(11, CoreMatchers.equalTo(result));
    }

    @Test
    public void should_handle_even_numbers_array() {
        int[] nums = {1, 3, 5, 7, 9, 11, 9, 7};
        int result = maxNumberInMountainSequence.mountainSequence(nums);
        assertThat(11, CoreMatchers.equalTo(result));
    }

    @Test
    public void should_handle_peak_appear_in_first_half() {
        int[] nums = {1, 3, 4, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int result = maxNumberInMountainSequence.mountainSequence(nums);
        assertThat(9, CoreMatchers.equalTo(result));
    }

}