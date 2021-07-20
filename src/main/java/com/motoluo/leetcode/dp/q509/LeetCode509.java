package com.motoluo.leetcode.q509;

public class LeetCode509 {

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 8, 13};
        int n = 5;
        System.out.println(dp(n));
        System.out.println(dp(n) == arr[n]);
        System.out.println(recursion(n));
        System.out.println(recursion(n) == arr[n]);
    }

    /**
     * 递归法
     *
     * @param n
     * @return
     */
    public static int recursion(int n) {
        if (n < 2) {
            return n;
        }
        return dp(n - 1) + dp(n - 2);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int dp(int n) {
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 0; i <= n - 1; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}


