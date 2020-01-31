package com.gatsby.sekiro;

import java.util.HashMap;
import java.util.Map;

public class T13_RomanToIngeter {
    public int romanToInt(String s) {
        int resule = 0;
        Map<String, Integer> flag = new HashMap<>();
        flag.put("I", 1);
        flag.put("V", 5);
        flag.put("X", 10);
        flag.put("L", 50);
        flag.put("C", 100);
        flag.put("D", 500);
        flag.put("M", 1000);

        String t = s;
        String[] data = new String[50];
        int index = 0;
        while (t.length() > 0) {
            data[index++] = t.substring(0, 1);
            t = t.substring(1);
        }

        index = 0;
        while (index < s.length()) {
            if (index + 1 < s.length() &&
                    (!data[index].equals(data[index + 1]) &&
                    (flag.get(data[index]) == 1 && (flag.get(data[index + 1]) == 5 || flag.get(data[index + 1]) == 10)) ||
                    (flag.get(data[index]) == 10 && (flag.get(data[index + 1]) == 50 || flag.get(data[index + 1]) == 100)) ||
                    (flag.get(data[index]) == 100 && (flag.get(data[index + 1]) == 500 || flag.get(data[index + 1]) == 1000)))) {
                resule += (flag.get(data[index + 1]) - flag.get(data[index]));
                index += 2;
            } else {
                resule += flag.get(data[index]);
                index += 1;
            }
        }
        return resule;
    }


}
