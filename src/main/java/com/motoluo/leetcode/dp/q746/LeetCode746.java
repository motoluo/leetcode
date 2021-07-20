package com.motoluo.leetcode.dp.q746;

public class LeetCode746 {

    /**
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
     * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
     * <p>
     * 输入：cost = [10, 15, 20]
     * 输出：15
     * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
     * <p>
     * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出：6
     * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(Math.min(dp(cost, 0), dp(cost, 1)));
        System.out.println(Math.min(dp(cost2, 0), dp(cost2, 1)));
        System.out.println(dp2(cost));
        System.out.println(dp2(cost2));
    }

    /**
     * 动态规划
     * 思路：每一步可走1阶或2阶，每一步都取2阶中最小花费，加和起来肯定是最小花费
     *
     * @param cost
     * @param start
     * @return
     */
    public static int dp(int[] cost, int start) {
        // 第一步花费（注意边界值：start取值0或1，cost的length可能为1）
        int r = 0;
        if (start < cost.length) {
            r = cost[start];
        } else {
            r = cost[0];
        }
        // 后续每步花费
        for (int i = start + 1; i < cost.length; ) {
            if (i + 1 >= cost.length) {
                return r;
            }
            if (cost[i] >= cost[i + 1]) {
                r += cost[i + 1];
                // 花费后，说明已经上到该阶梯
                i += 2;
            } else {
                r += cost[i];
                // 花费后，说明已经上到该阶梯
                i++;
            }
        }
        return r;
    }

    /**
     * 动态规划
     * 思路：第n步花费 = 最后一步为1阶、2阶花费的最小值
     *
     * @param cost
     * @return
     */
    public static int dp2(int[] cost) {
        int n = cost.length;
        // 花费的结果
        int[] dp = new int[n + 1];
        // 可以选择从下标为 0 或 1 的元素作为初始阶梯
        dp[0] = dp[1] = 0;
        // 第n步花费 = 最后一步为1阶、2阶花费的最小值
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

}
