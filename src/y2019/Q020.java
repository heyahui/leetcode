package y2019;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S 和 T 只含有小写字母以及字符 '#'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q020 {

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> stack = new Stack<>();
            for (char c : S.toCharArray()) {
                if (c == '#') {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
            Stack<Character> stack1 = new Stack<>();
            for (char c : T.toCharArray()) {
                if (c == '#') {
                    if (!stack1.empty()) {
                        stack1.pop();
                    }
                } else {
                    stack1.push(c);
                }
            }
            if (stack.size() != stack1.size()) {
                return false;
            }
            while (!stack.empty()) {
                if (!stack.pop().equals(stack1.pop())) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution1 {
        public boolean backspaceCompare(String S, String T) {
            char[] s = new char[200];
            int p = 0;
            for (char c : S.toCharArray()) {
                if (c == '#') {
                    if (p != 0) {
                        s[--p] = 0;
                    }
                } else {
                    s[p++] = c;
                }
            }
            char[] t = new char[200];
            p = 0;
            for (char c : T.toCharArray()) {
                if (c == '#') {
                    if (p != 0) {
                        t[--p] = 0;
                    }
                } else {
                    t[p++] = c;
                }
            }
            for (int i = 0; i < 200; i++) {
                if (s[i] != t[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
