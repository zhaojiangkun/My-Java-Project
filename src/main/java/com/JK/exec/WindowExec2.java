package com.JK.exec;

import java.util.HashMap;
import java.util.Map;

/**
 * 不定长滑动窗口
 * @Author: ZhaoJiangKun
 * @Date: 2024-12-02 14:27
 */
public class WindowExec2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ar"));
    }


    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        for (int left = 0; left < s.length(); left++){
            int right = left;
            Map<Character, Integer> map = new HashMap<>();
            while (right < s.length()){
                if (map.containsKey(s.charAt(right))){
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
