package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a text file file.txt that contains list of phone numbers (one per line), write a one liner
 * bash script to print all valid phone numbers.
 *
 * <p>You may assume that a valid phone number must appear in one of the following two formats:
 * (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)
 *
 * <p>You may also assume each line in the text file must not contain leading or trailing white
 * spaces.
 *
 * <p>Example:
 *
 * <p>Assume that file.txt has the following content:
 *
 * <p>987-123-4567 123 456 7890 (123) 456-7890 Your script should output the following valid phone
 * numbers:
 *
 * <p>987-123-4567 (123) 456-7890
 */
@LeetCode
@FirstRound
@Easy
public class ValidPhoneNumbers {}
