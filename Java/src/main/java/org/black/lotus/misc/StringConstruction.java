package org.black.lotus.misc;

public class StringConstruction {
    public String construct(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }

        char[] chars = s.toCharArray();
        return new String(chars);
    }
}
