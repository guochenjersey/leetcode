package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidIPAddressTest {

  @Test
  public void is_valid_ipv4() {
    String validIPv41 = "172.16.254.1";
    String validIPv42 = "202.117.8.9";
    String invalidIPv1 = "0.0.0.0";

    String validIPv6_1 = "2001:db8:85a3:0:0:8A2E:0370:7334";
    String validIPv6_2 = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
    String invalidIPv6_3 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";

    ValidIPAddress validIPAddress = new ValidIPAddress();
    String res1 = validIPAddress.validIPAddress(validIPv41);
    String res2 = validIPAddress.validIPAddress(validIPv42);
    String res3 = validIPAddress.validIPAddress(invalidIPv1);
    String invalidIPv6_2 = validIPAddress.validIPAddress(invalidIPv6_3);

    String validIPV4 = "172.16.254.1";
    String invalidIPv42 = "00.0.0.0";

    String validIPV6 = validIPAddress.validIPAddress(validIPv6_1);
    String invalidIPv6 = validIPAddress.validIPAddress(validIPv6_2);
    String s = validIPAddress.validIPAddress(validIPV4);

    assertEquals("IPv4", res1);
    assertEquals("IPv4", res2);
    assertEquals("IPv4", res3);

    assertEquals("IPv6", validIPV6);
    assertEquals("Neither", invalidIPv6);
    assertEquals("Neither", invalidIPv6_2);
    assertEquals("IPv4", s);
    assertEquals("Neither", validIPAddress.validIPAddress(invalidIPv42));
  }
}
