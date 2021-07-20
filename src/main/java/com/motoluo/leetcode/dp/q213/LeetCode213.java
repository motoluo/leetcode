package com.motoluo.leetcode.dp.q213;

public class LeetCode213 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * <p>
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1)));
        System.out.println(Math.max(dp(nums2, 0, nums2.length - 2), dp(nums2, 1, nums2.length - 1)));
        System.out.println(Math.max(dp2(nums, 0, nums.length - 2), dp2(nums, 1, nums.length - 1)));
        System.out.println(Math.max(dp2(nums2, 0, nums2.length - 2), dp2(nums2, 1, nums2.length - 1)));
    }

    /**
     * 动态规划
     * 思路：从索引0或1开始，不触发报警，则一定是求索引+=2的和，求索引0、1开始的最大值
     *
     * @param nums
     * @return
     */
    public static int dp(int[] nums, int start, int end) {
        int r = 0;
        // start取值0或1
        if (start < nums.length) {
            r = nums[start];
        } else {
            r = nums[0];
        }
        for (int i = start + 2; i <= end; i += 2) {
            r += nums[i];
        }
        return r;
    }

    /**
     * 动态规划
     * 思路：
     * 小于等于2时：取边界值
     * 大于2时：dp[n] = dp[n-2] + nums[n]；恰好取n时最值为dp[n]，不取n时最大值为dp[n-1]
     *
     * @param nums
     * @return
     */
    public static int dp2(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
