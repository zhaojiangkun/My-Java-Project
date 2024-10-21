package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-21 14:04
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        System.out.println(threeSum(nums).toString());

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // 待返回的三元组
        List<List<Integer>> triples = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // 检测重复的 nums[i]
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while(l < r) {
                // 检测重复的 nums[l] 并防止越界
                while(l > i + 1 && l < nums.length && nums[l] == nums[l - 1])
                    l++;

                // 检测重复的 nums[r] 并防止越界
                while(r < nums.length - 1 && r > i && nums[r] == nums[r + 1])
                    r--;

                // 防止 l, r 错位
                if(l >= r) break;

                // 均不重复再按照两数之和的思路
                // 等同于判断 nums[l] + nums[r] > -nums[i]
                if(nums[i] + nums[l] + nums[r] > 0) r--;

                    // 等同于判断 nums[l] + nums[r] < -nums[i]
                else if(nums[i] + nums[l] + nums[r] < 0) l++;

                    // nums[l] + nums[r] == nums[i], 三元组符合，添加入结果
                else {
                    triples.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                }
            }
        }

        return triples;
    }
}
