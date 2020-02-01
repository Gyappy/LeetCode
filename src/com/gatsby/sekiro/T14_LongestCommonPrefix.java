package com.gatsby.sekiro;

public class T14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int maxLen = 0;
        for (String str : strs) {
            if (str.length() == 0) {
                return result;
            }
            if (maxLen < str.length()) {
                maxLen = str.length();
            }
        }
        boolean same = true;
        for (int i = 0; i < maxLen; i++) {
            char t = ' ';
            for (String str : strs) {
                if (i > (str.length() - 1)) {
                    return result;
                }
                if (t == ' ') {
                    t = str.charAt(i);
                } else {
                    if (str.charAt(i) != t) {
                        same = false;
                        break;
                    }
                }
            }
            if (same) {
                result = result + t;
            } else {
                return result;
            }
        }
        return result;
    }
}
