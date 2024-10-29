package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-28 9:53
 */
public class Permute {



    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();
        List<List<Integer>> res = permute(nums);
        System.out.println(res.toString());


    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //路径
        LinkedList<Integer> path = new LinkedList<>();
        //标记
        boolean[] used = new boolean[nums.length];
        backstrack(res, path, used, nums);
        return res;
    }

    private static void backstrack(List<List<Integer>> res, LinkedList<Integer> path, boolean[] used, int[] nums){
        if (path.size() == nums.length){
            res.add(new LinkedList<>(path));
        }
        for (int i = 0; i < nums.length; i++){
            //已经用过的跳过
            if (Boolean.TRUE.equals(used[i])){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backstrack(res, path, used, nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
