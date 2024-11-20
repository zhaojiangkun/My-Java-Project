package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.Arrays;

/**
 * 最长连续序列
 * @Author: ZhaoJiangKun
 * @Date: 2024-11-17 19:54
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
//        System.out.println(longestConsecutive(nums));

        System.out.println(maxArea(nums));

    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        //临时结果
        int tMax = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1]) {
                //如果两个相邻的值相同，则临时结果-1
                if (nums[i] == nums[i - 1]){
                    tMax--;
                }
                //如果相邻的两个值差为1，则临时结果+1
                tMax++;
            } else {
                //相邻值相差不是1，则更新最大变量的值
                tMax = 1;
            }
            res = Math.max(tMax, res);

        }
        return nums.length == 0 ? 0 : res;
    }

    /**
     * 盛最多水的容器
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;

    }
}
