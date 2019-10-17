package y2019;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *  
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 解释:
 *
 *  
 *
 * 说明:
 *
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q057 {
    public static void main(String[] args) {
        new Q057().new Solution().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    class Solution {
        int cols;
        int rows;

        public int[] findDiagonalOrder(int[][] matrix) {
            rows = matrix.length;
            if (rows > 0) {
                cols = matrix[0].length;
                if (cols > 0) {
                    int[] seq = new int[rows * cols];
                    int idx = 0;
                    seq[idx++] = matrix[0][0];
                    int row = 0;
                    int col = 0;
                    while (row != rows - 1 || col != cols - 1) {
                        int[] p = getNewPosition(row, col);
                        col = p[0];
                        row = p[1];
                        if (row == 0 || col == cols - 1) {
                            for (; row <= rows - 1 && col >= 0; row++, col--) {
                                seq[idx++] = matrix[row][col];
                            }
                            row--;
                            col++;
                        } else {
                            for (; row >= 0 && col <= cols - 1; row--, col++) {
                                seq[idx++] = matrix[row][col];
                            }
                            row++;
                            col--;
                        }
                    }
                    return seq;
                }
            }
            return new int[0];
        }

        private int[] getNewPosition(int row, int col) {
            if (col == cols - 1) {
                return new int[]{col, row + 1};
            }
            if (row == 0) {
                return new int[]{col + 1, 0};
            }
            if (row == rows - 1) {
                return new int[]{col + 1, row};
            }
            if (col == 0) {
                return new int[]{0, row + 1};
            }
            return new int[0];
        }
    }
}
