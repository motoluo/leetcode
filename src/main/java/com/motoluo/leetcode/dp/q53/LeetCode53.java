package com.motoluo.leetcode.dp.q53;

import java.util.Arrays;

public class LeetCode53 {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * <p>
     * 输入：nums = [-100000]
     * 输出：-100000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-10000};
        System.out.println(dp(nums));
        System.out.println(dp(nums2));
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static int sum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = 0, start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp > maxSum) {
                maxSum = temp;
                start = i;
                end = i;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp > maxSum) {
                    maxSum = temp;
                    start = i;
                    end = j + 1;
                }
            }
        }
        int[] ints = Arrays.copyOfRange(nums, start, end);
        System.out.println(Arrays.toString(ints));
        return maxSum;
    }

    /**
     * 动态规划
     * dp[n] = nums[i] + dp[n-1]
     *
     * @param nums
     * @return
     */
    public static int dp(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }

}
