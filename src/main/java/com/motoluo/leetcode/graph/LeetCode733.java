package com.motoluo.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author moto
 * @Date 2021/7/30
 */
public class LeetCode733 {

    /**
     * 733. 图像渲染
     * <p>
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     * 最后返回经过上色渲染后的图像。
     * <p>
     * 输入:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析:
     * 在图像的正中间，(坐标(sr,sc)=(1,1)),
     * 在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，
     * 因为它不是在上下左右四个方向上与初始点相连的像素点。
     * <p>
     * 注意:
     * image 和 image[0] 的长度在范围 [1, 50] 内。
     * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
     * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flood-fill
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        System.out.println(Arrays.deepToString(bfs(image, sr, sc, newColor)));
        System.out.println(Arrays.deepToString(dfs(image, sr, sc, newColor)));
    }

    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    /**
     * 广度优先（BFS）
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] bfs(int[][] image, int sr, int sc, int newColor) {
        int sColor = image[sr][sc];
        if (sColor == newColor) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int maxX = image.length, maxY = image[0].length;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < maxX && mx >= 0 && my < maxY && my >= 0 && image[mx][my] == sColor) {
                    image[mx][my] = newColor;
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        return image;
    }

    /**
     * 深度优先（DFS）
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] dfs(int[][] image, int sr, int sc, int newColor) {
        int sColor = image[sr][sc];
        if (sColor == newColor) {
            return image;
        }
        s(image, sr, sc, sColor, newColor);
        return image;
    }

    public static void s(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = sr + dx[i], my = sc + dy[i];
                if (mx < image.length && mx >= 0 && my < image[0].length && my >= 0 && image[mx][my] == color) {
                    s(image, mx, my, color, newColor);
                }
            }
        }
    }

}
