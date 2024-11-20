package com.JK.exec;

import com.JK.util.ScanInUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口练习
 * https://leetcode.cn/circle/discuss/0viNMK/
 * @Author: ZhaoJiangKun
 * @Date: 2024-11-20 14:27
 */
public class WindowExec {

    public static void main(String[] args) {
//        String s = "pdzndkhhoujpqyex";
//        int k = 5;
//        System.out.println(maxVowels(s, k));

        int[] nums = ScanInUtil.scanInToIntArray();
        int k = ScanInUtil.scanInToInt();
//        int threshold = ScanInUtil.scanInToInt();
        for (int average : getAverages(nums, k)) {
            System.out.println(average);
        }
    }

    /**
     * 半径为k的子数组平均值
     * @param nums
     * @param k
     * @return
     */
    public static int[] getAverages(int[] nums, int k) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            //前k个和后k个肯定是-1
            if (i < k || i + k + 1 > nums.length){
                res[i] = -1;
            }
        }
        long len = 2 * k + 1;
        long tempSum = 0;
        for (int i = 0; i < nums.length; i++){
            //进入窗口
            tempSum += nums[i];
            //更新
            if (i - len + 1 < 0) continue;
            if (res[k] != -1){
                res[k] = (int) (tempSum / len);
                k++;
            };
            //离开窗口
            tempSum -= nums[(int) (i - len + 1)];
//            if (res[i] == -1) continue;

        }
        return res;
    }

    /**
     * 大小为k且平均值大于等于阈值的子数组数目
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int maxThreshold = k * threshold;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++){
            //进入窗口
            tempSum += arr[i];

            //更新
            if (i - k + 1 < 0) continue;
            if (tempSum >= maxThreshold) count++;

            //离开窗口
            tempSum -= arr[i - k + 1];
        }
        return count;
    }

    /**
     * 定长子串中元音的最大数目
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int max = 0;
        int tempMax = 0;
        for (int i = 0; i < s.length(); i++) {
            //进入窗口,如果进入的那个字母是元音则tempMax加一
            if(set.contains(s.charAt(i))){
                tempMax++;
            }
            if (i - k + 1 < 0) continue;
            //更新窗口内的答案
            max = Math.max(max, tempMax);
            //离开窗口,如果离开的那个字母是元音则将tempMax减一
            if(set.contains(s.charAt(i - k + 1))) tempMax--;
        }
        return max;
    }

    /**
     * 子数组最大平均数
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double tempMax = 0;
        for (int i = 0; i < nums.length; i++) {
            //进入窗口
            tempMax += nums[i];
            if (i - k + 1 < 0) continue;
            //更新
            max = Math.max(max, tempMax);

            //离开窗口
            tempMax -= nums[i - k + 1];
        }
        return max / k;
    }
}
