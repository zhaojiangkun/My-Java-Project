package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.Arrays;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-23 15:29
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        int k = ScanInUtil.scanInToInt();
        System.out.println(subarraySum(nums, k));

    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j >= 0; j--){
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;

    }
}
