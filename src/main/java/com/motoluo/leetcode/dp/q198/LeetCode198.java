package com.motoluo.leetcode.q198;

public class LeetCode198 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(Math.max(dp(nums, 0), dp(nums, 1)));
        System.out.println(Math.max(dp(nums2, 0), dp(nums2, 1)));
        System.out.println(dp2(nums));
        System.out.println(dp2(nums2));
    }

    /**
     * 动态规划
     * 思路：从索引0或1开始，不触发报警，则一定是求索引+=2的和，求索引0、1开始的最大值
     *
     * @param nums
     * @return
     */
    public static int dp(int[] nums, int start) {
        int r = 0;
        // start取值0或1
        if (start < nums.length) {
            r = nums[start];
        } else {
            r = nums[0];
        }
        for (int i = start + 2; i < nums.length; i += 2) {
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
    public static int dp2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    /**
     * 动态规划
     * <p>
     * 思路：内存优化
     *
     * @param nums
     * @return
     */
    public static int dp3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
