package com.JK.str;

import com.JK.util.ScanInUtil;

/**
 * 最后一个单词的长度
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-17 13:55
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = ScanInUtil.scanInToStr();
        System.out.println(lengthOfLastWord(str));

    }

    public static int lengthOfLastWord(String str){
        String[] strings = str.split(" ");
        if (strings[strings.length - 1].isEmpty()){
            return strings[strings.length - 2].length();
        }
        return strings[strings.length - 1].length();
    }
}
