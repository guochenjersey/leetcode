package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementTest {

    @Test
    public void should_remove_element() {
        int[] nums = {2};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, 3);

    }
}