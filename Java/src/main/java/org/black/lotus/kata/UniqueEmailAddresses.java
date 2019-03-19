package org.black.lotus.kata;

import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@FirstRound
@Easy
public class UniqueEmailAddresses {

  public int numUniqueEmails(String[] emails) {
    if (emails == null || emails.length == 0) {
      return 0;
    }

    Set<String> res = new HashSet<>();
    for (String email : emails) {
      StringBuilder mailBuilder = new StringBuilder();
      boolean startDomain = false;
      boolean seenPlus = false;
      for (char c : email.toCharArray()) {
        if (c == '@') {
          startDomain = true;
          mailBuilder.append("@");
          continue;
        }

        if (!startDomain) {
          if (c == '.') {
            continue;
          }

          if (c == '+') {
            seenPlus = true;
          }
        }
        if (seenPlus && !startDomain) {
          continue;
        }

        mailBuilder.append(c);
      }
      res.add(mailBuilder.toString());
    }

    return res.size();
  }
}
