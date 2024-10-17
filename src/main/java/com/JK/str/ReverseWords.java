package com.JK.str;

/**
 * 反转字符串中的单词
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-17 14:07
 */
public class ReverseWords {
    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String str){
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--){
            sb.append(strings[i]);
            if (i > 0 && !strings[i].isEmpty()){
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
