package com.JK.exec;

import com.JK.util.ScanInUtil;

import java.util.*;

/**
 * 滑动窗口练习
 * https://leetcode.cn/circle/discuss/0viNMK/
 *
 * @Author: ZhaoJiangKun
 * @Date: 2024-11-20 14:27
 */
public class WindowExec {

    public static void main(String[] args) {
        String s = "00110110";
//        int k = 2;
//        System.out.println(hasAllCodes(s, k));

//        List<Integer> nums = ScanInUtil.scanInToIntList();
        int[] nums = ScanInUtil.scanInToIntArray();
        int m = ScanInUtil.scanInToInt();
//        int k = ScanInUtil.scanInToInt();
        System.out.println(maxScore(nums, m));
//        int threshold = ScanInUtil.scanInToInt();
//        for (int average : getAverages(nums, k)) {
//            System.out.println(average);
//        }
    }

    /**
     * 可获得的最大点数
     * 拿走最大点数的牌，剩下的牌都是连续的，
     * 因此最大点数和 + 最小点数和 = 总点数和，最小点数和最小时，最大点数和最大
     * @param cardPoints
     * @param k
     * @return
     */
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int tempSum = 0;
        int res = Integer.MAX_VALUE;
        int windowLength = cardPoints.length - k;
        for (int i = 0; i < cardPoints.length; i++) {
            //进入窗口
            tempSum += cardPoints[i];
            sum += cardPoints[i];

            if (windowLength <= 0) continue;

            if(i - windowLength + 1 < 0) continue;

            //更新最小值
            res = Math.min(tempSum, res);

            //移出窗口
            tempSum -= cardPoints[i - windowLength + 1];
        }

        return windowLength <= 0 ? sum : sum - res;
    }

    /**
     * 长度为k子数组中的最大和
     * @param nums
     * @param k
     * @return
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        long temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //进入窗口
            temp += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i - k + 1 < 0) continue;
            //更新最大值

            if (map.size() == k) {
                res = Math.max(res, temp);
            }
            //移出窗口左边界值
            temp -= nums[i - k + 1];
            map.computeIfPresent(nums[i - k + 1], (key, value) -> value - 1 == 0 ? null : value - 1);
        }
        return res;
    }

    /**
     * 几乎唯一子数组的最大和
     *
     * @param nums
     * @param m
     * @param k
     * @return
     */
    public static long maxSum(List<Integer> nums, int m, int k) {
        long res = 0;
        long temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            //进入窗口
            temp += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);

            //校验窗口大小
            if (i - k + 1 < 0) continue;

            //更新最大值:遍历当前窗口数组是否为几乎唯一子数组，如果是则更新最大值
            if (map.size() >= m) {
                res = Math.max(res, temp);
            }

            //移出窗口左边界值
            temp -= nums.get(i - k + 1);
            //如果窗口左边界的值仅有一个，则将该key设为null
            map.computeIfPresent(nums.get(i - k + 1), (key, value) -> value - 1 == 0 ? null : value - 1);
        }
        return res;
    }

    /**
     * 检查一个字符串是否包含所有长度为k的二进制子串
     *
     * @param s
     * @param k
     * @return
     */
    public static boolean hasAllCodes(String s, int k) {
        int size = (int) Math.pow(2, k);
        Set<String> set = new HashSet<>();
        //窗口大小为k，从字符串的k-1位置开始遍历
        for (int i = k - 1; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            //获取字符串的子串，开始位置为当前索引的前k个位置，如果i-k<0就从0开始
            //结束位置为当前索引
            sb.append(s.substring(i - k < 0 ? 0 : i - k, i));
            //如果子串长度不为k，则跳过
            if (sb.toString().length() != k) continue;
            set.add(sb.toString());
        }
        return set.size() == size;
    }

    /**
     * 爱生气的书店老板
     *
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //顾客满意的最大数量等于老板不生气的数量customerCount + 窗口内老板生气的数量
        int maxCount = 0;
        int tempCount = 0;

        int customersCount = 0;
        for (int i = 0; i < grumpy.length; i++) {
            //进入窗口
            if (grumpy[i] == 0) {
                //计算老板不生气时的顾客数量和
                customersCount += customers[i];
            } else {
                //窗口内老板生气时的数量
                tempCount += customers[i];
            }

            if (i - minutes + 1 < 0) continue;

            //更新最大值
            maxCount = Math.max(maxCount, tempCount);

            //离开窗口
            if (grumpy[i - minutes + 1] == 1) { //如果离开窗口的是生气的，则减去
                tempCount -= customers[i - minutes + 1];
            }
        }
        return maxCount + customersCount;
    }

    /**
     * 得到k个黑块的最少涂色次数
     * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，
     * 表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
     * <p>
     * 给你一个整数 k ，表示想要 连续 黑色块的数目。
     * <p>
     * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
     * <p>
     * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
     *
     * @param blocks
     * @param k
     * @return
     */
    public static int minimumRecolors(String blocks, int k) {
        //最少操作次数
        int minCount = Integer.MAX_VALUE;
        //当前窗口中白色块的数量
        int whiteCount = 0;
        for (int i = 0; i < blocks.length(); i++) {
            //进入窗口
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            //更新窗口内的最少操作次数，也就是白色块的数量
            if (i - k + 1 < 0) continue;
            minCount = Math.min(minCount, whiteCount);

            //离开窗口
            if (blocks.charAt(i - k + 1) == 'W') {
                whiteCount--;
            }

        }
        return minCount;
    }

    /**
     * 半径为k的子数组平均值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] getAverages(int[] nums, int k) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //前k个和后k个肯定是-1
            if (i < k || i + k + 1 > nums.length) {
                res[i] = -1;
            }
        }
        long len = 2 * k + 1;
        long tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //进入窗口
            tempSum += nums[i];
            //更新
            if (i - len + 1 < 0) continue;
            if (res[k] != -1) {
                res[k] = (int) (tempSum / len);
                k++;
            }
            ;
            //离开窗口
            tempSum -= nums[(int) (i - len + 1)];
//            if (res[i] == -1) continue;

        }
        return res;
    }

    /**
     * 大小为k且平均值大于等于阈值的子数组数目
     *
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int maxThreshold = k * threshold;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            //进入窗口
            tempSum += arr[i];

            //更新
            if (i - k + 1 < 0) continue;
            if (tempSum >= maxThreshold) count++;

            //离开窗口
            tempSum -= arr[i - k + 1];
        }
        return count;
    }

    /**
     * 定长子串中元音的最大数目
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int max = 0;
        int tempMax = 0;
        for (int i = 0; i < s.length(); i++) {
            //进入窗口,如果进入的那个字母是元音则tempMax加一
            if (set.contains(s.charAt(i))) {
                tempMax++;
            }
            if (i - k + 1 < 0) continue;
            //更新窗口内的答案
            max = Math.max(max, tempMax);
            //离开窗口,如果离开的那个字母是元音则将tempMax减一
            if (set.contains(s.charAt(i - k + 1))) tempMax--;
        }
        return max;
    }

    /**
     * 子数组最大平均数
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double tempMax = 0;
        for (int i = 0; i < nums.length; i++) {
            //进入窗口
            tempMax += nums[i];
            if (i - k + 1 < 0) continue;
            //更新
            max = Math.max(max, tempMax);

            //离开窗口
            tempMax -= nums[i - k + 1];
        }
        return max / k;
    }
}
