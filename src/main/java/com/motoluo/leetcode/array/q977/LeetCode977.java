package com.motoluo.leetcode.array.q977;

import java.util.Arrays;

public class LeetCode977 {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * <p>
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * <p>
     * 提示：
     * 1 <= nums.length <= 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums 已按 非递减顺序 排序
     * <p>
     * 进阶：请你设计时间复杂度为 O(n) 的算法解决本问题
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(force(nums)));
        System.out.println(Arrays.toString(force(nums2)));
        System.out.println(Arrays.toString(doublePoint(nums)));
        System.out.println(Arrays.toString(doublePoint(nums2)));
    }

    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public static int[] force(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 双指针
     * 思路：
     * 1、“非递减顺序”排序（i<j时，A[i]<A[j]或A[i]=A[j]），也可理解为递增
     * 2、用双指针首尾平方相比即可
     *
     * @param nums
     * @return
     */
    public static int[] doublePoint(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, cur = n - 1; i <= j; cur--) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[cur] = nums[i] * nums[i];
                i++;
            } else {
                ans[cur] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }


}
