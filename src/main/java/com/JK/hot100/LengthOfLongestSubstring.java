package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-22 13:33
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = ScanInUtil.scanInToStr();
        System.out.println(lengthOfLongestSubstring(str));

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
