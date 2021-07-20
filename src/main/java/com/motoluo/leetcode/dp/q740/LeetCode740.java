package com.motoluo.leetcode.dp.q740;

public class LeetCode740 {

    /**
     * 给你一个整数数组 nums ，你可以对它进行一些操作。
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * <p>
     * 输入：nums = [3,4,2]
     * 输出：6
     * 解释：
     * 删除 4 获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
     * <p>
     * 输入：nums = [2,2,3,3,3,4]
     * 输出：9
     * 解释：
     * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
     * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
     * 总共获得 9 个点数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-and-earn
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println(dp(nums));
        System.out.println(dp(nums2));
    }

    /**
     * 动态规划
     * 思路：与打家劫舍等常规dp的区别是由索引关联变成了值关联，思考将值关联变成索引关联，即可用打家劫舍等常规dp的方式解决
     * 假设：删除3，可得点数为3，若有n个3，则可得点数3n。创建新数组，将删除的元素作为的索引，可得点数作为值，转化为取一个数组不相邻和最大值
     *
     * @param nums
     * @return
     */
    public static int dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 将value转为index
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int[] sums = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]] += nums[i];
        }
        // 不相邻和最大值
        int[] dp = new int[max + 1];
        dp[0] = sums[0];
        dp[1] = Math.max(sums[0], sums[1]);
        for (int i = 2; i < max + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sums[i], dp[i - 1]);
        }
        return dp[max];
    }

}
