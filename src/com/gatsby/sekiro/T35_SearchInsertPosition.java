package com.gatsby.sekiro;

public class T35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] < target) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= target) {
                return i;
            }
            if (nums[i] < target && nums[i + 1] >= target) {
                return i+1;
            }
        }
        return nums.length;
    }
}
