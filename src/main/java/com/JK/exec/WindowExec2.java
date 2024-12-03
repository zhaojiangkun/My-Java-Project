package com.JK.exec;

import com.JK.util.ScanInUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 不定长滑动窗口
 *
 * @Author: ZhaoJiangKun
 * @Date: 2024-12-02 14:27
 */
public class WindowExec2 {
    public static void main(String[] args) {
        int[] nums = ScanInUtil.scanInToIntArray();

        System.out.println(totalFruit(nums));
    }

    /**
     * 水果成篮
     *
     * @param fruits
     * @return
     */
    public static int totalFruit(int[] fruits) {
        int res = 0;
        int left = 0;
        int baskets = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.get(fruits[right]) == 1) {
                //水果种类+1
                baskets++;
                //如果水果种类大于2，则移动左指针
                while (baskets > 2) {
                    //将左指针对应的水果种类减一
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    //如果左指针对应的水果种类为0，则水果种类-1
                    if (map.get(fruits[left]) == 0) {
                        baskets--;
                    }
                    left++;
                }
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }

    /**
     * 找到最长的半重复子字符串
     *
     * @param s
     * @return
     */
    public static int longestSemiRepetitiveSubstring(String s) {
        int res = 1;
        char[] chars = s.toCharArray();
        int left = 0;
        int same = 0;
        for (int right = left + 1; right < chars.length; right++) {
            if (chars[right] == chars[right - 1]) {
                same++;
                if (same > 1) {
                    left++;
                    while (chars[left] != chars[left - 1]) {
                        left++;
                        same = 1;
                    }
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 尽可能使字符串相等
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        //window数组为s t每个字符的转换差值
        int[] window = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            window[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
//        int left = 0;
        int res = 0;
        for (int left = 0; left < window.length; left++) {
            int right = left;
            int cost = 0;
//            int currentCost = maxCost;
            while (right < window.length) {
                //判断当前窗口是否溢出
                if ((cost >= maxCost && window[right] > 0) || (cost + window[right] > maxCost)) {
                    break;
                } else {
                    //处理窗口右边界值
                    cost += window[right];
                    right++;
                }
                res = Math.max(res, right - left);
            }
        }
        return res;
    }

    /**
     * 删除一个元素以后全为1的最长子数组
     *
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            int right = left;
            int zero = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    zero++;
                    right++;
                    if (zero > 1) {
                        break;
                    }
                } else {
                    right++;
                }
                res = Math.max(res, right - left);
            }
        }
        return res - 1;
    }

    /**
     * 每个字符最多出现两次的最长字符串
     */
    public static int maximumLengthSubstring(String s) {
        int maxLength = 1;
//        int left = 0;
//        while (left < s.length()) {


        for (int left = 0; left < s.length(); left++) {
            int right = left;
            Map<Character, Integer> map = new HashMap<>();
            while (right < s.length()) {
                if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= 2) {
//                    left = right;
//                    map.clear();
                    break;
                } else {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                    right++;
                }
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return s.isEmpty() ? 0 : maxLength;
    }


    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        for (int left = 0; left < s.length(); left++) {
            int right = left;
            Map<Character, Integer> map = new HashMap<>();
            while (right < s.length()) {
                if (map.containsKey(s.charAt(right))) {
                    maxLength = Math.max(maxLength, right - left);
                    break;
                } else {
                    map.put(s.charAt(right), right);
                    right++;
                }
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return s.isEmpty() ? 0 : maxLength;
    }
}
