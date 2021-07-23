package com.motoluo.leetcode.array.q278;

public class LeetCode278 {

    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * <p>
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * <p>
     * 输入：n = 1, bad = 1
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-bad-version
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 5, bad = 4;
        int n2 = 1, bad2 = 1;
        int n3 = 2126753390, bad3 = 1702766719;
        System.out.println(binarySearch(n, bad));
        System.out.println(binarySearch(n2, bad2));
        System.out.println(binarySearch(n3, bad3));
    }

    /**
     * 有序列二分查找
     *
     * @param n
     * @return
     */
    public static int binarySearch(int n, int bad) {
        int left = 0, mid = 0, right = n;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid, bad)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int n, int bad) {
        if (n >= bad) {
            return true;
        }
        return false;
    }
}
