package y2019;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q034 {
    class Solution {
        public int[] sortedSquares(int[] A) {
            int lIdx = 0;
            int rIdx = A.length - 1;
            for (int i = 0; i <= rIdx; i++) {
                if (A[i] >= 0) {
                    break;
                } else {
                    A[i] = -A[i];
                }
            }
            int[] arr = new int[A.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                if (A[lIdx] > A[rIdx]) {
                    arr[i] = A[lIdx] * A[lIdx];
                    lIdx++;
                } else {
                    arr[i] = A[rIdx] * A[rIdx];
                    rIdx--;
                }
            }
            return arr;
        }
    }
}
