package com.gatsby.sekiro;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenhuigu on 17/3/19.
 */
public class T1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int result1 = 0, result2 = 0;
        Map<Integer, Integer> flag = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            flag.put(nums[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag.get(target - nums[i]) != null && flag.get(target - nums[i]) > 0 && flag.get(target - nums[i])-1 != i) {
                result1 = i;
                result2 = flag.get(target - nums[i]) - 1;
                break;
            }
        }
        return new int[]{result1, result2};
    }

    public int[] wonderfulCode(int[] nums, int target){
        Map<Integer, Integer> mData = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mData.containsKey(target - nums[i]) && mData.get(target - nums[i]) != i) {
                return new int[]{mData.get(target - nums[i]), i};
            }
            mData.put(nums[i], i);
        }
        return nums;
    }
}
