package org.black.lotus.lintcode;

import org.black.lotus.misc.SVNRepo;

public class FirstBadVersion {

    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
