package org.black.lotus.kata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Twitter;

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or
 * neither.
 *
 * <p>IPv4 addresses are canonically represented in dot-decimal notation, which consists of four
 * decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * <p>Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is
 * invalid.
 *
 * <p>IPv6 addresses are represented as eight groups of four hexadecimal digits, each group
 * representing 16 bits. The groups are separated by colons (":"). For example, the address
 * 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros
 * among four hexadecimal digits and some low-case characters in the address to upper-case ones, so
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper
 * cases).
 *
 * <p>However, we don't replace a consecutive group of zero value with a single empty group using
 * two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is
 * an invalid IPv6 address.
 *
 * <p>Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * <p>Note: You may assume there is no extra space or special characters in the input string.
 *
 * <p>Example 1: Input: "172.16.254.1"
 *
 * <p>Output: "IPv4"
 *
 * <p>Explanation: This is a valid IPv4 address, return "IPv4". Example 2: Input:
 * "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * <p>Output: "IPv6"
 *
 * <p>Explanation: This is a valid IPv6 address, return "IPv6". Example 3: Input: "256.256.256.256"
 *
 * <p>Output: "Neither"
 *
 * <p>Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
@LeetCode
@Twitter
public class ValidIPAddress {

  static final String IPv4 = "IPv4";
  static final String IPv6 = "IPv6";
  static final String NEITHER = "Neither";
  static final Set<Character> VALID_HEX =
      new HashSet<>(
          Arrays.asList(
              '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'));

  public String validIPAddress(String IP) {
    if (IP == null || IP.length() == 0) {
      return NEITHER;
    }

    return isIPv4(IP) ? IPv4 : (isIPv6(IP) ? IPv6 : NEITHER);
  }

  private boolean isIPv4(String IP) {
    int counter = 0;
    char[] chars = IP.toCharArray();
    for (char c : chars) {
      if (c == '.') {
        ++counter;
      }
    }

    if (counter != 3) {
      return false;
    }

    String[] split = IP.split("\\.");
    if (split.length != 4) {
      return false;
    }
    try {
      for (String part : split) {
        int num = Integer.parseInt(part);
        if (part.startsWith("0") && part.length() > 1) {
          return false;
        }

        if (num < 0 || num > 255) {
          return false;
        }

        for (char c : part.toCharArray()) {
          if (!Character.isDigit(c)) {
            return false;
          }
        }
      }
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  private boolean isIPv6(String IP) {
    if (IP == null || IP.length() == 0) {
      return false;
    }
    char[] chars = IP.toCharArray();
    int counter = 0;
    for (char c : chars) {
      if (c == ':') {
        ++counter;
      }
    }

    if (counter != 7) {
      return false;
    }

    String[] parts = IP.split(":");
    if (parts.length != 8) {
      return false;
    }

    try {
      for (String part : parts) {
        if (part.length() == 0 || part.length() > 4) {
          return false;
        }
        for (int i = 0; i < part.length(); ++i) {
          Character o = part.charAt(i);
          if (!VALID_HEX.contains(Character.toUpperCase(o))) {
            return false;
          }
        }
      }
    } catch (Exception e) {
      return false;
    }

    return true;
  }
}
