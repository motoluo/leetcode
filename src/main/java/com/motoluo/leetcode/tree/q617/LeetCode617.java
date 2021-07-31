package com.motoluo.leetcode.tree.q617;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode617 {

    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * <p>
     * 输入:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * 输出:
     * 合并后的树:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     * <p>
     * 注意: 合并必须从两个树的根节点开始。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        System.out.println(mergeTrees(root1, root2));
    }

    /**
     * 深度优先（DFS）
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode t = new TreeNode(root1.val + root2.val);
        t.left = mergeTrees(root1.left, root2.left);
        t.right = mergeTrees(root1.right, root2.right);
        return t;
    }

    /**
     * 广度优先（BFS）
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        bfs(root1, root2);
        return root1;
    }

    public static void bfs(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            TreeNode f = queue.poll();
            if (f == null) {
                continue;
            }
            if (f.left != null) {
                if (r.left == null) {
                    r.left = new TreeNode();
                }
                r.left.val = r.left.val + f.left.val;
                queue.offer(r.left);
                queue.offer(f.left);
            }
            if (f.right != null) {
                if (r.right == null) {
                    r.right = new TreeNode();
                }
                r.right.val = r.right.val + f.right.val;
                queue.offer(r.right);
                queue.offer(f.right);
            }
        }
    }

    public static void dfs(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            TreeNode f = queue.poll();
            if (f == null) {
                continue;
            }
            if (f.left != null) {
                if (r.left == null) {
                    r.left = new TreeNode();
                }
                r.left.val = r.left.val + f.left.val;
                queue.offer(r.left);
                queue.offer(f.left);
            }
            if (f.right != null) {
                if (r.right == null) {
                    r.right = new TreeNode();
                }
                r.right.val = r.right.val + f.right.val;
                queue.offer(r.right);
                queue.offer(f.right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
