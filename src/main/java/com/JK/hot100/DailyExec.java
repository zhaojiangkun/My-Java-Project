package com.JK.hot100;

import java.util.*;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-11-07 10:06
 */
public class DailyExec {

    /**
     * 是否回文串
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase().trim();
        System.out.println(str);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(str.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(str.charAt(right)) && left < right) {
                right--;
            }
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 判断子序列
     * @return
     */
    public static boolean isSubsequence(String s, String t){
        LinkedList<Character> linkedList = new LinkedList<>();
        //将t中的字符放入链表中
        for (int i = s.length() - 1; i >= 0; i--){
            linkedList.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++){
            if(linkedList.peek() != null && linkedList.peek().equals(t.charAt(i))){
                linkedList.pop();
            }
        }
        return linkedList.isEmpty();
    }

    /**
     * 两数之和
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        return new int[]{};
    }

    /**
     * 盛最多水的容器
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }

    /**
     * 长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= target){
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }

    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while(end < s.length()){
//            map.put(s.charAt(end), 1);
            if(map.containsKey(s.charAt(end))){
                res = Math.max(res, end - start);
                map.clear();
//                map.remove(s.charAt(start));
                start++;
                end = start;
            }
            map.put(s.charAt(end), start);
            end++;
        }
        return Math.max(res, map.size());

    }


    /**
     * 有效的数独
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;

        // 验证每一行是否符合条件
        for (int i = 0; i < n; i++) {
            Set<Character> setRow = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!setRow.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        // 验证每一列是否符合条件
        for (int j = 0; j < n; j++) {
            Set<Character> setCol = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '.') {
                    if (!setCol.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        // 验证每一单元矩阵是否符合条件
        for (int sign = 0; sign < n; sign++) {
            Set<Character> setUnitBoard = new HashSet<>();
            int unitRow = (sign % 3) * 3;
            int unitCol = (sign / 3) * 3;

            for (int i = unitRow; i < unitRow + 3; i++) {
                for (int j = unitCol; j < unitCol + 3; j++) {
                    if (board[i][j] != '.') {
                        if (!setUnitBoard.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        Map<Character, Integer> mMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            mMap.put(c, mMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if(!mMap.containsKey(c) || mMap.get(c) <= 0){
                return false;
            }
            mMap.put(c, mMap.get(c) - 1);
        }
        return true;
    }

    /**
     * 同构字符串
     * @param s
     * @param t
     * @return
     */



}
