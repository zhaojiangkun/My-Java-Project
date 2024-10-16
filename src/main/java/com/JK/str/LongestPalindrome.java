package com.JK.str;

import com.JK.util.ScanInUtil;

/**
 * 最长回文子串
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-16 9:51
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        String str = ScanInUtil.scanInToStr();
        System.out.println(longestPalindrome(str));

    }

    public static String longestPalindrome(String s) {

        int maxLeft = 0;
        int maxLen = 0;
        int len = 1;
        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(mid)){
                left--;
                len++;
            }
            while (right <= s.length() - 1 && s.charAt(right) == s.charAt(mid)){
                right++;
                len++;
            }
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len = len + 2;
            }
            if (len > maxLen){
                maxLen = len;
                maxLeft = left;
            }
            len = 1;
        }


        return s.substring(maxLeft + 1, maxLeft + maxLen + 1);
    }
}
