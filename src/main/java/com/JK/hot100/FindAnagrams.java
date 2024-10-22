package com.JK.hot100;

import com.JK.util.ScanInUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-22 13:54
 */
public class FindAnagrams {
    public static void main(String[] args) {
        String a = ScanInUtil.scanInToStr();
        String b = ScanInUtil.scanInToStr();
        System.out.println(isAnagrams(a, b));
        System.out.println(findAnagrams(a, b).toString());


    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int r = p.length() - 1;
        while (r < s.length()){
            if (isAnagrams(s.substring(l, r + 1), p)){
                res.add(l);
            }
            l++;
            r++;
        }
        return res;
    }

    public static boolean isAnagrams(String s, String p){
        if (s.equals(p)) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int j = 0; j < s.length(); j++){
            if (!map.containsKey(s.charAt(j))){
                return false;
            }
            Integer t = map.get(s.charAt(j));
            if (t <= 0) return false;
            t--;
            map.put(s.charAt(j), t);
        }
        return true;
    }
}
