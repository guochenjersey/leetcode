package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    @Test
    public void should_jump_to_end() {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGame jumpGame = new JumpGame();
        boolean res = jumpGame.canJump(nums);

        assertEquals(true, res);
    }
}