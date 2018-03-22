package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

import java.util.ArrayList;
import java.util.List;


/**
 * Give a string, you can choose to split the string after one character or two adjacent characters,
 * and make the string to be composed of only one character or two characters. Output all possible results.
 * <p>
 * Example
 * Given the string "123"
 * return [["1","2","3"],["12","3"],["1","23"]]
 */
@FirstRound
@LintCode
@Easy
public class SplitString {

    public List<List<String>> splitString(String source) {
        List<List<String>> result = new ArrayList<>();
        if (source == null || source.length() == 0) {
            return result;
        }
        List<String> path = new ArrayList<>();
        dfs(result, path, 0, source);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> path,
                     int startIndex, String source) {
        if (startIndex >= source.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(source.substring(startIndex, startIndex + 1));
        dfs(result, new ArrayList<>(path), startIndex + 1, source);
        path.remove(path.size() - 1);

        if (startIndex + 2 <= source.length()) {
            path.add(source.substring(startIndex, startIndex + 2));
            dfs(result, new ArrayList<>(path), startIndex + 2, source);
            path.remove(path.size() - 1);
        }
    }
}
