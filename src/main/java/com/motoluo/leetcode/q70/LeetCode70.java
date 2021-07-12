package com.motoluo.leetcode.q70;

public class LeetCode70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println(dp(n));
        System.out.println(recursion(n));
        System.out.println(mRecursion(n));
    }

    /**
     * 递归
     * 1-5级例子找规律：1，2，3，5，8
     * 得出斐波那契数列 f(x) = f(x-1) + f(x-2)
     *
     * @param n
     * @return
     */
    public static int recursion(int n) {
        if (n <= 2) {
            return n;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    /**
     * 记忆化递归
     * 1-5级例子找规律：1，2，3，5，8
     * 得出斐波那契数列 f(x) = f(x-1) + f(x-2)
     *
     * @param n
     * @return
     */
    public static int[] arr;

    public static int mRecursion(int n) {
        arr = new int[n + 1];
        return helper(n, arr);
    }

    public static int helper(int n, int[] arr) {
        if (arr[n] > 0) {
            return arr[n];
        }
        if (n <= 2) {
            arr[n] = n;
            return arr[n];
        }
        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }

    /**
     * 动态规划
     * 1-5级例子找规律：1，2，3，5，8
     * 得出斐波那契数列 f(x) = f(x-1) + f(x-2)
     *
     * @param n
     * @return
     */
    public static int dp(int n) {
        if (n <= 2) {
            return n;
        }
        int p = 1, q = 2, r = 0;
        for (int i = 0; i < n - 2; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

}
