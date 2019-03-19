package org.black.lotus.kata;

import com.sun.org.apache.xpath.internal.operations.String;
import java.util.*;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LintCode;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of
 * similar word pairs pairs, determine if two sentences are similar.
 *
 * <p>For example, words1 = great acting skills and words2 = fine drama talent are similar, if the
 * similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
 *
 * <p>Note that the similarity relation is not transitive. For example, if "great" and "fine" are
 * similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 *
 * <p>However, similarity is symmetric. For example, "great" and "fine" being similar is the same as
 * "fine" and "great" being similar.
 *
 * <p>Also, a word is always similar with itself. For example, the sentences words1 = ["great"],
 * words2 = ["great"], pairs = [] are similar, even though there are no specified similar word
 * pairs.
 *
 * <p>Finally, sentences can only be similar if they have the same number of words. So a sentence
 * like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 *
 * <p>1.The length of words1 and words2 will not exceed 1000. 2.The length of pairs will not exceed
 * 2000. 3.The length of each pairs[i] will be 2. 4.The length of each words[i] and pairs[i][j] will
 * be in the range [1, 20].
 */
@LintCode
@Easy
public class SentenceSimilarity {
  /**
   * @param words1: a list of string
   * @param words2: a list of string
   * @param pairs: a list of string pairs
   * @return: return a boolean, denote whether two sentences are similar or not
   */
  public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {

    if (words1 == null || words2 == null || words1.length != words2.length) {
      return false;
    }

    if ((words1.length == 0)) {
      return true;
    }

    Map<String, Set<String>> leftToRightStringMaps = new HashMap<>();
    Map<String, Set<String>> rightToLeftStringMaps = new HashMap<>();

    initStringMaps(pairs, leftToRightStringMaps, rightToLeftStringMaps);

    for (int i = 0; i < words1.length; ++i) {
      if (leftToRightStringMaps.get(words1[i]) != null
          && leftToRightStringMaps.get(words1[i]).contains(words2[i])) {
        continue;
      }

      if (rightToLeftStringMaps.get(words1[i]) != null
          && rightToLeftStringMaps.get(words1[i]).contains(words2[i])) {
        continue;
      }

      return false;
    }

    return true;
  }

  private void initStringMaps(
      List<List<String>> pairs,
      Map<String, Set<String>> leftToRightStringMaps,
      Map<String, Set<String>> rightToLeftStringMaps) {
    for (List<String> pair : pairs) {
      leftToRightStringMaps.putIfAbsent(pair.get(0), new HashSet<>());
      rightToLeftStringMaps.putIfAbsent(pair.get(1), new HashSet<>());

      leftToRightStringMaps.get(pair.get(0)).add(pair.get(0));
      leftToRightStringMaps.get(pair.get(0)).add(pair.get(1));

      rightToLeftStringMaps.get(pair.get(1)).add(pair.get(1));
      rightToLeftStringMaps.get(pair.get(1)).add(pair.get(0));
    }
  }
}
