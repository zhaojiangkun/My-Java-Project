package com.JK.str;

/**
 * 最长公共前缀
 *
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-17 13:40
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "fli"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            for (; j < str.length() && j < res.length(); j++) {
                if (res.charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.isEmpty()) {
                return res;
            }
        }
        return res;
    }

}
