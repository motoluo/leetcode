package com.motoluo.leetcode.dp.q55;

public class LeetCode55 {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
        System.out.println(canJump2(nums));
        System.out.println(canJump2(nums2));
    }

    /**
     * 贪心法
     * 思路：题中指的是可到达而不是恰好到最后一个下表，
     * 采用贪心法，把每一个可以作为起跳点的都尝试跳一次，没有出现原地踏步，则可以到达最后一个
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 上一步的最大值与当前索引比较，如果出现i>max，说明已经原地踏步超过一次（最后一个为0的情况可原地踏步一次）
            if (i > max) {
                return false;
            }
            // 每个索引下一次能跳到的最值
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    /**
     * 贪心法
     * 思路：
     * 1、如果所有元素都>=1，则可直接判断为true。因为我可以一次走一步，像一只乌龟一样走到终点。
     * 2、如果有元素为0，可以把0当作“坑”，为了不掉进坑里，我需要判断坑之前的位置，是否允许我一次跳多格，像一只兔子一样越过这个坑，
     * 如果可以越过这个坑，则继续往终点走，并继续判断未来的其他坑。如果我永远都无法越过某一个坑，则返回false，我将不可能到达终点。
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 || i == nums.length - 1) {
                continue;
            }
            // 元素为0，跳过坑次数，最后一个下标为0可以不跳过
            int jump = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > i - j) {
                    jump++;
                }
            }
            // 跳不过坑
            if (jump == 0) {
                return false;
            }
        }
        return true;
    }

}
