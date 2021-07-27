package com.motoluo.leetcode.node.q876;

public class LeetCode876 {

    /**
     * 876. 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * <p>
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * <p>
     * 提示：给定链表的结点数介于 1 和 100 之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.buildHead(nums);
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        ListNode head2 = ListNode.buildHead(nums2);

        System.out.println(middleNode(head));
        System.out.println(middleNode(head2));

        System.out.println(slowFastPointer(head));
        System.out.println(slowFastPointer(head2));
    }

    /**
     * 两次递归
     * 思路：第一次递归找出链表长度，第二次地推找出中间节点
     * 缺点：递归整个链表长度
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        int length = ListNode.length(head, 1);
        return ListNode.subNode(head, length / 2 + 1, 1);
    }

    /**
     * 快慢指针
     * 思路：慢指针一次走1，快指针一次走2，快指针到链尾时，慢指针刚好到middle
     *
     * @param head
     * @return
     */
    public static ListNode slowFastPointer(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
            if (dep >= target) {
                return head;
            }
            head = head.next;
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
