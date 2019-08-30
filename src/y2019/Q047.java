package y2019;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q047 {
    public static void main(String[] args) {
        new Q047().new Solution().generateParenthesis(0);
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            recursiveCall(ret, "", n, n);
            return ret;
        }

        private void recursiveCall(List<String> list, String str, int l, int r) {
            if (r == 0) {
                list.add(str);
                return;
            }
            if (l == r) {
                recursiveCall(list, str + '(', l - 1, r);
            } else {
                if (l > 0) {
                    recursiveCall(list, str + '(', l - 1, r);
                }
                recursiveCall(list, str + ')', l, r - 1);
            }
        }
    }
}
