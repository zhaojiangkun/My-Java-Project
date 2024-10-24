package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口最大值
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-24 12:48
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        int k = ScanInUtil.scanInToInt();
        int[] res = maxSlidingWindow(nums, k);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length <= k){
            int max = findMax(nums,0, nums.length);
            return new int[]{max};
        }
        int l = 0;
        int r = l + k;
        while(r <= nums.length){
            int max = findMax(nums,l, r);
            list.add(max);
            r++;
            l++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static int findMax(int[] nums, int l, int r){
        int max = nums[l];
        for(int i = l; i < r; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}
