package com.gatsby.sekiro;

/**
 * Created by chenhuigu on 17/3/19.
 */
public class T7_ReverseInteger {
    public static int reverse(int x) {
        int material = Math.abs(x);
        int result = 0;

        while (material > 0) {
            int t = material % 10;
            if (result != 0 && (Integer.MAX_VALUE / result < 10 || (Integer.MAX_VALUE - result) < t)) {
                result = 0;
                break;
            }
            result = result * 10 + t;
            material /= 10;
        }

        return x > 0 ? result : 0 - result;
    }

}
