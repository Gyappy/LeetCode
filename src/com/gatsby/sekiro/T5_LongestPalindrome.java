package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:滑动窗口+dp 效率一般。还可以使用空心扩展法 以及时间效率更高的Manacher算法
 * @since 2020-06-03
 */
public class T5_LongestPalindrome {
    public String longestPalindrome(String s) {
        int i, j;
        int f[][] = new int[1005][1005];
        int winLen = 3;
        int result = 1, resultI = 0, resultJ = 0;
        if (s == null || s.length() == 0) {
            return "";
        }
        for (i = 0; i < s.length() - 1; i++) {
            f[i][i] = 1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1] = 2;
                if (f[i][i + 1] > result) {
                    result = f[i][i + 1];
                    resultI = i;
                    resultJ = i + 1;
                }
            }

        }
        while (winLen <= s.length()) {
            for (i = 0; i < s.length() - winLen + 1; i++) {
                j = i + winLen - 1;
                if (i + 1 < s.length() && j - 1 >= 0) {
                    if (f[i + 1][j - 1] > 0 && s.charAt(i) == s.charAt(j)) {
                        f[i][j] = f[i + 1][j - 1] + 2;
                    }
                }

                if (f[i][j] > result) {
                    result = f[i][j];
                    resultI = i;
                    resultJ = j;
                }
            }
            winLen++;
        }
        return s.substring(resultI, resultJ + 1);
    }
}
