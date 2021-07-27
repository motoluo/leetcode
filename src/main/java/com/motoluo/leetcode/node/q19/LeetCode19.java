package com.motoluo.leetcode.node.q19;

public class LeetCode19 {

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * <p>
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.buildHead(nums);
        int n = 2;
        int[] nums2 = {1};
        ListNode head2 = ListNode.buildHead(nums2);
        int n2 = 1;
        int[] nums3 = {1, 2};
        ListNode head3 = ListNode.buildHead(nums3);
        int n3 = 1;

        System.out.println(slowFastPointer(head, n));
        System.out.println(slowFastPointer(head2, n2));
        System.out.println(slowFastPointer(head3, n3));
    }

    /**
     * 快慢指针
     * 思路：快指针比慢指针快n，则快指针到尾是，慢指针（增加一个头节点引用head）在倒数第n-1位置，修改next
     *
     * @param head
     * @return
     */
    public static ListNode slowFastPointer(ListNode head, int n) {
        // 引用head指针
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = ListNode.subNode(head, n, 1);
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        /**
         * 本地构建node
         *
         * @param nums
         * @return
         */
        public static ListNode buildHead(int[] nums) {
            ListNode head = new ListNode(nums[0]);
            setNextNode(head, nums, 1);
            return head;
        }

        public static ListNode setNextNode(ListNode head, int[] nums, int dep) {
            if (dep >= nums.length) {
                return head;
            }
            if (head.next == null) {
                head.next = new ListNode(nums[dep]);
            }
            return setNextNode(head.next, nums, ++dep);
        }

        /**
         * 获取子链表
         *
         * @param head
         * @param target
         * @param dep
         * @return
         */
        public static ListNode subNode(ListNode head, int target, int dep) {
            head = head.next;
            if (dep >= target) {
                return head;
            }
            return subNode(head, target, ++dep);
        }

        /**
         * 获取链表长度
         *
         * @param head
         * @param dep
         * @return
         */
        public static int length(ListNode head, int dep) {
            if (head.next == null) {
                return dep;
            }
            return length(head.next, ++dep);
        }
    }


}
