package com.motoluo.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author moto
 * @Date 2021/7/30
 */
public class LeetCode695 {

    /**
     * 695. 岛屿的最大面积
     * <p>
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     * <p>
     * 示例 1:
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     * <p>
     * 示例 2:
     * [[0,0,0,0,0,0,0,0]]
     * 对于上面这个给定的矩阵, 返回 0。
     * <p>
     * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-area-of-island
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] image = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        },
                image2 = {{0, 0, 0, 0, 0, 0, 0, 0}},
                image3 = {
                        {1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}
                };

//        System.out.println(dfs(image));
//        System.out.println(dfs(image2));

//        System.out.println(bfs(image));
//        System.out.println(bfs(image2));
        System.out.println(bfs(image3));
    }

    /**
     * 上下左右位移时，坐标偏移量
     */
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    /**
     * 深度优先（DFS）
     *
     * @param image
     * @return
     */
    public static int dfs(int[][] image) {
        int ans = 0;
        int m = image.length;
        if (m == 0) {
            return ans;
        }
        int n = image[0].length;
        if (n == 0) {
            return ans;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                ans = Math.max(ans, dfs(image, i, j, m, n, count));
            }
        }
        return ans;
    }

    public static int dfs(int[][] image, int x, int y, int m, int n, int count) {
        if (image[x][y] == 0) {
            return count;
        }
        // 技巧1：将已经计算过的坐标值改为0，防止多次计算。 技巧2：可用hash缓存（性能比直接技巧1差了10倍）
        image[x][y] = 0;
        ++count;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i], my = y + dy[i];
            if (mx >= 0 && mx < m && my >= 0 && my < n && image[mx][my] == 1) {
                count = dfs(image, mx, my, m, n, count);
            }
        }
        return count;
    }

    /**
     * 广度优先（BFS）
     *
     * @param image
     * @return
     */
    public static int bfs(int[][] image) {
        int ans = 0;
        int m = image.length;
        if (m == 0) {
            return ans;
        }
        int n = image[0].length;
        if (n == 0) {
            return ans;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == 0) {
                    continue;
                }
                int count = 0;
                // 单源点
                queue.offer(new int[]{i, j});
                image[i][j] = 0;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0], y = poll[1];
                    count = bfs(image, x, y, m, n, count, queue);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    public static int bfs(int[][] image, int x, int y, int m, int n, int count, Queue<int[]> queue) {
        // 技巧1：将已经计算过的坐标值改为0，防止多次计算。 技巧2：可用hash缓存（性能比直接技巧1差了10倍）
        ++count;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i], my = y + dy[i];
            if (mx >= 0 && mx < m && my >= 0 && my < n && image[mx][my] == 1) {
                queue.offer(new int[]{mx, my});
                image[mx][my] = 0;
            }
        }
        return count;
    }

}
