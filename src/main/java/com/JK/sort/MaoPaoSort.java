package com.JK.sort;

import com.JK.util.ScanInUtil;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-07 12:51
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }

    }

    /**
     * 冒泡
     * @param nums
     */
    private static void sort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                }
            }
        }
    }
}
