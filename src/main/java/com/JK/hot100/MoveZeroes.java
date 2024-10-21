package com.JK.hot100;

import com.JK.util.ScanInUtil;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-21 13:43
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        int[] res = moveZeroes(nums);
        for (int r : res) System.out.print(r + " ");

    }

    public static int[] moveZeroes(int[] nums){
        if (nums.length == 1) return nums;
        int i = 0;
        int j = i + 1;
        while (j < nums.length){
            if (nums[i] == 0 && nums[j] != 0){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
                i++;
            } else if (nums[i] == 0 && nums[j] == 0){
                j++;
            } else {
                i++;
                j++;
            }
        }
        return nums;
    }
}
