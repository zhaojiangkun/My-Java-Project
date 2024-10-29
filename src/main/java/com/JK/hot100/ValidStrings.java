package com.JK.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成不含相邻零的二进制字符串
 *
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-29 11:24
 */
public class ValidStrings {
    public static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, result);
        return result;
    }

    private static void generate(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // Append '1' and recurse
        generate(current + "1", n, result);

        // Append '0' only if the last character is not '0'
        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            generate(current + "0", n, result);
        }
    }

    public static void main(String[] args) {

        List<String> validStrings = validStrings(3);
        System.out.println(validStrings);
    }
}
