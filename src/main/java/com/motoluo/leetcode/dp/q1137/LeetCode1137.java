package com.motoluo.leetcode.q1137;

public class LeetCode1137 {

    /**
     * 泰波那契序列 Tn 定义如下： 
     * <p>
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * <p>
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 4, 7, 13};
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
        if (n == 2) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2) + recursion(n - 3);
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
        if (n == 2) {
            return 1;
        }
        int p = 0, q = 1, r = 1, s = 0;
        for (int i = 0; i < n - 2; i++) {
            s = p + q + r;
            p = q;
            q = r;
            r = s;
        }
        return s;
    }

}

