package com.JK.sort;

import java.util.Arrays;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-07 11:35
 */
public class XuanZeSort {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,0};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     *   选择排序
     *
     * @param nums
     */
    private static void sort(int[] nums) {
        //分界下标值，左边为已排序的，右边为未排序的
        int current = 0;

        while (current < nums.length) {
            int minIndex = current;
            for (int j = current + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, current, minIndex);
            current++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
