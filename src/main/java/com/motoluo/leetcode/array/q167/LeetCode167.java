package com.motoluo.leetcode.array.q167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode167 {

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * <p>
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * <p>
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     * <p>
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     * <p>
     * 提示：
     * 2 <= numbers.length <= 3 * 10^4
     * -1000 <= numbers[i] <= 1000
     * numbers 按 递增顺序 排列
     * -1000 <= target <= 1000
     * 仅存在一个有效答案
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] nums2 = {2, 3, 4};
        int target2 = 6;
        int[] nums3 = {-1, 0};
        int target3 = -1;
        int[] nums4 = {1, 3, 4, 4};
        int target4 = 8;
        System.out.println(Arrays.toString(force(nums, target)));
        System.out.println(Arrays.toString(force(nums2, target2)));
        System.out.println(Arrays.toString(force(nums3, target3)));
        System.out.println(Arrays.toString(hash(nums, target)));
        System.out.println(Arrays.toString(hash(nums2, target2)));
        System.out.println(Arrays.toString(hash(nums3, target3)));
        System.out.println(Arrays.toString(doublePointer(nums, target)));
        System.out.println(Arrays.toString(doublePointer(nums2, target2)));
        System.out.println(Arrays.toString(doublePointer(nums3, target3)));
        System.out.println(Arrays.toString(binarySearch(nums, target)));
        System.out.println(Arrays.toString(binarySearch(nums2, target2)));
        System.out.println(Arrays.toString(binarySearch(nums3, target3)));
        System.out.println(Arrays.toString(binarySearch(nums4, target4)));
    }

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public static int[] force(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * hash缓存
     * 思路：x = target - nums[i]
     *
     * @param nums
     * @return
     */
    public static int[] hash(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = i + 1;
                ans[1] = map.get(nums[i]) + 1;
                return ans;
            }
        }
        return ans;
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static int[] doublePointer(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    /**
     * 有序列二分查找
     *
     * @param nums
     * @return
     */
    public static int[] binarySearch(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // left>i
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[i] + nums[mid] == target) {
                    ans[0] = i + 1;
                    ans[1] = mid + 1;
                    return ans;
                } else if (nums[i] + nums[mid] < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return ans;
    }

}
