package com.motoluo.leetcode.array.q344;

import java.util.Arrays;

public class LeetCode344 {

    /**
     * 344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * <p>
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * <p>
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] nums = {"h", "e", "l", "l", "o"};
        String[] nums2 = {"H", "a", "n", "n", "a", "h"};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
        reverse(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * @param nums
     * @return
     */
    public static void reverse(String[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            String temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    /**
     * @param nums
     * @return
     */
    public static void reverse(char[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            char temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }


}
