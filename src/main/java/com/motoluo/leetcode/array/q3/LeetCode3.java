package com.motoluo.leetcode.array.q3;

import java.util.HashMap;

public class LeetCode3 {

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 输入: s = ""
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(slidingWindow(s));
        String s2 = "bbbbb";
        System.out.println(slidingWindow(s2));
        String s3 = "pwwkew";
        System.out.println(slidingWindow(s3));
        String s4 = "";
        System.out.println(slidingWindow(s4));
    }

    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public static int slidingWindow(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // left、right为相同元素时，left+1即map.get(c) + 1
                left = Math.max(left, map.get(c) + 1);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(c, right);
        }
        return ans;
    }


}
