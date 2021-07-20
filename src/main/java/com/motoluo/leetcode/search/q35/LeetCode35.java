package com.motoluo.leetcode.search.q35;

public class LeetCode35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * <p>
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * <p>
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * <p>
     * 输入: nums = [1,3,5,6], target = 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int target2 = 7;
        int target3 = 0;
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch(nums, target2));
        System.out.println(binarySearch(nums, target3));
    }

    /**
     * 有序列二分查找 O(log n)
     *
     * @param nums
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (left <= right) {
            // 此处不用 mid = (left + right) / 2; 防止int溢出
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}
