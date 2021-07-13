package com.motoluo.leetcode.q45;

public class LeetCode45 {

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * <p>
     * 输入: [2,3,0,1,4]
     * 输出: 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(dp(nums));
        System.out.println(dp(nums2));
    }

    /**
     * 贪心法
     * 思路：求数组元素和>=数组长度的最少元素的个数，每次跳都选最大的 todo
     *
     * @param nums
     * @return
     */
    public static int dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0, step = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (max >= nums.length) {
//                return step;
//            }
//            if (i < max) {
//                continue;
//            }
//            max = Math.max(i + nums[i], max);
//            step++;
//        }
        return step;
    }

}
