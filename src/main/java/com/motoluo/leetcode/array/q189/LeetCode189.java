package com.motoluo.leetcode.array.q189;

import java.util.Arrays;

public class LeetCode189 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * <p>
     * 提示：
     * 1 <= nums.length <= 2 * 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        force(nums, k);
        System.out.println(Arrays.toString(nums));
        force(nums2, k2);
        System.out.println(Arrays.toString(nums2));
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
        reverse(nums, k);
        System.out.println(Arrays.toString(nums));
        reverse(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public static void force(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i + k < n) {
                ans[i + k] = nums[i];
            } else {
                ans[i + k - n] = nums[i];
            }
        }
        nums = ans;
    }

    /**
     * 环状替换
     * 思路：TODO 不好理解，暂不考虑此解
     *
     * @param nums
     * @param k
     * @return
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 数组翻转
     * 思路：
     * 1、[1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
     * 2、[7,6,5,4,3,2,1] -> [7,6,5,1,2,3,4]
     * 3、[7,6,5,1,2,3,4] -> [5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     * @return
     */
    public static void reverse(int[] nums, int k) {
        int start = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, start, nums.length - 1);
        reverse(nums, 0, start - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }


}
