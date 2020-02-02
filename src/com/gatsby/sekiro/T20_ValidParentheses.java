package com.gatsby.sekiro;

import java.util.HashMap;
import java.util.Stack;

public class T20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<String> mStack = new Stack<>();
        HashMap mMap = new HashMap<String, String>();
        mMap.put("{", "0");
        mMap.put("[", "0");
        mMap.put("(", "0");
        mMap.put("}", "1");
        mMap.put("]", "1");
        mMap.put(")", "1");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (mStack.empty()) {
                if (mMap.get(String.valueOf(s.charAt(i))).equals("1")) {
                    return false;
                }
            }

            if (mMap.get(String.valueOf(s.charAt(i))).equals("0")) {
                mStack.push(String.valueOf(s.charAt(i)));
            } else {
                String temp = mStack.pop();
                if (mMap.get(temp).equals("0")
                        && ((temp.equals("(") && s.charAt(i) != ')') ||
                        (temp.equals("[") && s.charAt(i) != ']') ||
                        (temp.equals("{") && s.charAt(i) != '}'))) {
                    return false;
                }
            }

        }
        return mStack.empty();
    }
}
