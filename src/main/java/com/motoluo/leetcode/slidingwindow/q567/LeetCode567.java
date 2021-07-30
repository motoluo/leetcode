package com.motoluo.leetcode.slidingwindow.q567;

import java.util.Arrays;

public class LeetCode567 {

    /**
     * 567. 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
     * <p>
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * <p>
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     * <p>
     * 提示：
     * 1 <= s1.length, s2.length <= 10^4
     * s1 和 s2 仅包含小写字母
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "ab";
        String s1 = "eidbaooo";
        String s2 = "eidboaoo";

        System.out.println(slidingWindow(s, s1));
        System.out.println(slidingWindow(s, s2));
    }

    /**
     * 滑动窗口
     * 思路：以s1为窗口，记录每个元素个数，在s2滑动记录每个元素个数，比较s1与s2元素个数是否相等（这里用数组保存）
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean slidingWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        // 26个字母
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        // 窗口初始化
        for (int i = 0; i < n; ++i) {
            // 按字母顺序
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            // 窗口滑入（元素计数+1）
            ++cnt2[s2.charAt(i) - 'a'];
            // 窗口滑出（元素计数-1）
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ans(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++arr1[s1.charAt(i) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            --arr2[s2.charAt(i - n) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

}
