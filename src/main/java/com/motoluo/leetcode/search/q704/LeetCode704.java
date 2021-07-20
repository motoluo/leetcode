package com.motoluo.leetcode.q704;

public class LeetCode704 {

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int target2 = 2;
        System.out.println(search(nums, target));
        System.out.println(search(nums, target2));
        System.out.println(doublePointer(nums, target));
        System.out.println(doublePointer(nums, target2));
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch(nums, target2));
    }

    /**
     * 遍历
     *
     * @param nums
     * @return
     */
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static int doublePointer(int[] nums, int target) {
        int end = nums.length - 1;
        for (int i = 0; i <= end / 2; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[end - i] == target) {
                return end - i;
            }
        }
        return -1;
    }

    /**
     * 二分查找（有序）
     *
     * @param nums
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, avg = 0;
        while (left <= right) {
            avg = (left + right) / 2;
            if (nums[avg] == target) {
                return avg;
            }
            if (nums[avg] < target) {
                left = avg + 1;
            } else {
                right = avg - 1;
            }
        }
        return -1;
    }


}
