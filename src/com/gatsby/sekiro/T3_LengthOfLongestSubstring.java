package com.gatsby.sekiro;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhuigu
 * @date 2020/12/11
 * @time 3:32 PM
 */
public class T3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int result = 1;
        if (s == null || s.length() < 1) { return 0; }
        Map<String, Integer> mMap = new HashMap<>();
        mMap.put(String.valueOf(s.charAt(0)), 0);
        for (int i = 1; i < s.length(); i++) {
            //如果和前面的区间里的字符发生重复
            if (mMap.get(String.valueOf(s.charAt(i))) != null
                && mMap.get(String.valueOf(s.charAt(i))) >= left) {
                left = mMap.get(String.valueOf(s.charAt(i))) + 1;
            }
            result = Math.max(i - left + 1, result);

            mMap.put(String.valueOf(s.charAt(i)), i);
        }
        result = Math.max(s.length() - left, result);
        return result;
    }
}
