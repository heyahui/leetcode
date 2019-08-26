package y2019;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q043 {
    public static void main(String[] args) {
        int i = new Q043().new Solution().totalNQueens(11);
        System.out.println(i);
    }

    class Solution {
        private int sum;

        public int totalNQueens(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            call(arr, 0);
            return sum;
        }

        private void call(int[] arr, int idx) {
            if (idx == arr.length - 1) {
                if (check(arr, idx)) {
                    sum++;
                }
            } else {
                for (int i = idx; i < arr.length; i++) {
                    int temp = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = temp;
                    if (check(arr, idx)) {
                        call(arr, idx + 1);
                        arr[idx] = arr[i];
                        arr[i] = temp;
                    } else {
                        arr[idx] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }

        private boolean check(int[] arr, int newIdx) {
            for (int i = 0; i <= newIdx; i++) {
                for (int j = i + 1; j <= newIdx; j++) {
                    if (arr[i] - arr[j] == i - j || arr[i] - arr[j] == j - i) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
