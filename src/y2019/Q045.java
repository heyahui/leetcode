package y2019;

import java.util.Arrays;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q045 {
    public static void main(String[] args) {
        int[] ints = new Q045().new Solution().countBits(16);
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] countBits(int num) {
            if (num == 0) {
                return new int[]{0};
            }
            if (num == 1) {
                return new int[]{0, 1};
            }
            int[] result = new int[num + 1];
            result[0] = 0;
            result[1] = 1;
            int p = 1;
            int k = 2;
            for (int i = 2; i <= num; i++) {
                if (i == k) {
                    result[i] = 1;
                    k *= 2;
                    p = 1;
                } else {
                    result[i] = 1 + result[p++];
                }
            }
            return result;
        }
    }
}
