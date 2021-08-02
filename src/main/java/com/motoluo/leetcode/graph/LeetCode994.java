package com.motoluo.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author moto
 * @Date 2021/7/30
 */
public class LeetCode994 {

    /**
     * 994. 腐烂的橘子
     * <p>
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     * <p>
     * 输入：[[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     * <p>
     * 输入：[[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     * <p>
     * 输入：[[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     * <p>
     * 提示：
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     * grid[i][j] 仅为 0、1 或 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        },
                matrix2 = {
                        {2, 1, 1},
                        {0, 1, 1},
                        {1, 0, 1},
                };
        System.out.println(bfs(matrix1));
        System.out.println(bfs(matrix2));
    }

    /**
     * 上下左右位移时，坐标偏移量
     */
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    /**
     * 广度优先（BFS）
     *
     * @param mat
     * @return
     */
    public static int bfs(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        if (m == 0) {
            return ans;
        }
        int n = mat[0].length;
        if (n == 0) {
            return ans;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty()) {
            return ans;
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];


        }
        return ans;
    }

}
