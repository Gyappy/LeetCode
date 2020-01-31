package com.gatsby.sekiro;

/**
 * Created by chenhuigu on 17/3/19.
 */
public class T9_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        //负数不是回文数
        if (x < 0) {
            return false;
        }
        String material = String.valueOf(x);
        int len = material.length();
        for (int i = 0; i < len / 2; i++) {
            if (material.charAt(i) != material.charAt(len - i - 1)) {
                return false;

            }
        }
        return true;
    }
}
