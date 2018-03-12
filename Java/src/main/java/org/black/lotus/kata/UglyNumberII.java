package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * TODO
 * */
@FirstRound
@LintCode
@NoIdeaOrBadIdeaInitially
public class UglyNumberII {
    private static int[] UGLY_NUMBERS = {2, 3, 5};

    public int nthUglyNumber(int n) {
        if (n == 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }

        int counter = 1;

       return 1;
    }
}
