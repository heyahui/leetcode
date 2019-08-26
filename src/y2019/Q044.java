package y2019;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q044 {
    public static void main(String[] args) {
        int[][] arr = new Q044().new Solution().generateMatrix(10);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            char way = 'r';
            int x = 0, y = 0;
            int[][] ret = new int[n][n];
            int max = n * n;
            for (int i = 1; i <= max; i++) {
                if (way == 'r') {
                    if (y < n && ret[x][y] == 0) {
                        ret[x][y++] = i;
                    } else {
                        way = 'd';
                        x++;
                        y--;
                        i--;
                    }
                } else if (way == 'd') {
                    if (x < n && ret[x][y] == 0) {
                        ret[x++][y] = i;
                    } else {
                        way = 'l';
                        x--;
                        y--;
                        i--;
                    }
                } else if (way == 'l') {
                    if (y >= 0 && ret[x][y] == 0) {
                        ret[x][y--] = i;
                    } else {
                        way = 'u';
                        x--;
                        y++;
                        i--;
                    }
                } else {
                    if (x >= 0 && ret[x][y] == 0) {
                        ret[x--][y] = i;
                    } else {
                        way = 'r';
                        x++;
                        y++;
                        i--;
                    }
                }
            }
            return ret;
        }
    }
}
