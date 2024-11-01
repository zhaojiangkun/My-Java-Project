package com.JK.hot100;

import com.JK.util.ScanInUtil;

/**
 * 删除有序数组中的重复项
 * @Author: ZhaoJiangKun
 * @Date: 2024-11-01 15:02
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 1;
        while(right < len){
            if(nums[left] != nums[right]){
                nums[left + 1] = nums[right];
                left++;
            }
            right ++;
        }
        return left + 1;
    }
}
