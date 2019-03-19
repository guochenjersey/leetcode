package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueEmailAddressesTest {

  @Test
  public void should_find_unique_emails() {
    String email1 = "test.email+alex@leetcode.com";
    String email2 = "test.e.mail+bob.cathy@leetcode.com";
    String email3 = "testemail+david@lee.tcode.co";
    String[] emails = {email1, email2, email3};

    UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
    int res = uniqueEmailAddresses.numUniqueEmails(emails);

    assertEquals(2, res);
  }
}
