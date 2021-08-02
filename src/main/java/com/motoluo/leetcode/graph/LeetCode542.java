package com.motoluo.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author moto
 * @Date 2021/7/30
 */
public class LeetCode542 {

    /**
     * 542. 01 矩阵
     * <p>
     * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     * <p>
     * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：[[0,0,0],[0,1,0],[0,0,0]]
     * <p>
     * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
     * 输出：[[0,0,0],[0,1,0],[1,2,1]]
     * <p>
     * 提示：
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 10^4
     * 1 <= m * n <= 10^4
     * mat[i][j] is either 0 or 1.
     * mat 中至少有一个 0 
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/01-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        },
                matrix2 = {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1},
                };

        System.out.println(Arrays.deepToString(bfs(matrix1)));
        System.out.println(Arrays.deepToString(bfs(matrix2)));
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
    public static int[][] bfs(int[][] mat) {
        int m = mat.length;
        if (m == 0) {
            return new int[][]{};
        }
        int n = mat[0].length;
        if (n == 0) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        int[][] visited = new int[m][n];
        // 多源点 BFS
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == 1 && visited[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    ans[nx][ny] = ans[x][y] + 1;
                    visited[nx][ny] = 1;
                }
            }
        }
        return ans;
    }

    /**
     * 广度优先-修改原队列
     *
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

}
