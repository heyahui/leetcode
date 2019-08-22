package y2019;

/**
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 *
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 *
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q035 {

    class Solution {

        private int[][] arr;

        public int numEnclaves(int[][] A) {
            arr = A;
            int rows = arr.length;
            int cols = arr[0].length;

            for (int i = 0; i < cols; i++) {
                recursiveCall(0, i);
                recursiveCall(rows - 1, i);
            }

            for (int i = 0; i < rows; i++) {
                recursiveCall(i, 0);
                recursiveCall(i, cols - 1);
            }

            int count = 0;
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    count += anInt;
                }
            }
            return count;
        }

        private void recursiveCall(int row, int col) {
            if (row < 0 || col < 0 || row > arr.length - 1 || col > arr[0].length - 1) {
                return;
            }
            if (arr[row][col] == 0) {
                return;
            }
            arr[row][col] = 0;
            recursiveCall(row - 1, col);
            recursiveCall(row + 1, col);
            recursiveCall(row, col - 1);
            recursiveCall(row, col + 1);
        }
    }
}
