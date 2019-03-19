package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.misc.SVNRepo;

/**
 * The code base version is an integer start from 1 to n. One day, someone committed a bad version
 * in the code case, so it caused this version and the following versions are all failed in the unit
 * tests. Find the first bad version.
 *
 * <p>You can call isBadVersion to help you determine which version is the first bad one. The
 * details interface can be found in the code's annotation part.
 *
 * <p>Notice Please read the annotation in code area to get the correct way to call isBadVersion in
 * different language. For example, Java is SVNRepo.isBadVersion(v)
 *
 * <p>Have you met this question in a real interview? Example Given n = 5:
 *
 * <p>isBadVersion(3) -> false isBadVersion(5) -> true isBadVersion(4) -> true Here we are 100% sure
 * that the 4th version is the first bad version.
 *
 * <p>Challenge You should call isBadVersion as few as possible.
 *
 * <p>Tags
 */
@FirstRound
@LintCode
@Accepted
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
