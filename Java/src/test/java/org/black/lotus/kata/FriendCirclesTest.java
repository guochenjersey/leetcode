package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendCirclesTest {

    @Test
    public void should_find_right_friends_circle() {
        FriendCircles friendCircles = new FriendCircles();
        int[][] relationship =  {{1,1,0},
                {1,1,0},
                {0,0,1}};

        int res = friendCircles.findCircleNum(relationship);
        assertEquals(2, res);

        int[][] relationship1 = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };

        int res1 = friendCircles.findCircleNum(relationship1);
        assertEquals(1, res1);
    }


}