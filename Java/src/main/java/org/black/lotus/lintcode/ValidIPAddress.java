package org.black.lotus.lintcode;

import java.util.Spliterators;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Twitter;

@LeetCode
@Twitter
public class ValidIPAddress {

  static final String IPv4 = "IPv4";
  static final String IPv6 = "IPv6";
  static final String NEITHER = "Neither";

  public String validIPAddress(String IP) {
    return NEITHER;
  }

  private boolean isIPv4(String IP) {
    String[] split = IP.split(".");
    return false;
  }

  public static void main(String... args) {
    ValidIPAddress validIPAddress = new ValidIPAddress();
    validIPAddress.isIPv4("202.344.12.23");
  }
}
