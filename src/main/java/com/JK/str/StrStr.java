package com.JK.str;

/**
 * 找出字符串中第一个匹配项的下标
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-17 14:25
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

    }
    public static int strStr(String haystack, String needle){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < haystack.length(); i++){
            if (haystack.substring(i).startsWith(needle)){
                return i;
            }
        }
        return -1;

    }
}
