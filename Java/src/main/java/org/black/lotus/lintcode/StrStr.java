package org.black.lotus.lintcode;

public class StrStr {
  public int strStr(String source, String target) {
    if (source == null || target == null) {
      return -1;
    }

    if (target.length() == 0) {
      return 0;
    }

    char[] sourceArray = source.toCharArray();
    char[] targetArray = target.toCharArray();
    int sourceLength = sourceArray.length;
    int targetLength = targetArray.length;

    boolean found = false;
    for (int i = 0; i <= sourceLength - targetLength; ++i) {
      for (int j = 0; j < targetLength; ++j) {
        if (sourceArray[i + j] != targetArray[j]) {
          found = false;
          break;
        } else {
          found = true;
        }
      }
      if (found) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String... args) {
    StrStr strStr = new StrStr();
    System.out.println(strStr.strStr("", "abc"));
  }
}
