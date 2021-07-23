package com.motoluo.leetcode.array.q283;

import java.util.Arrays;

public class LeetCode283 {

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 0, 1};
//        force(nums);
//        System.out.println(Arrays.toString(nums));
//        force(nums2);
//        System.out.println(Arrays.toString(nums2));
        doublePointer(nums);
        System.out.println(Arrays.toString(nums));
        doublePointer(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public static void force(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针
     * 思路：
     * 1、[0,1,0,3,12] -> [1,0,0,3,12] -> [1,3,0,0,12] -> [1,3,12,0,0]
     * 2、[0,0,1] -> [0,0,1] -> [1,0,0]
     *
     * @param nums
     * @return
     */
    public static void doublePointer(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

}
