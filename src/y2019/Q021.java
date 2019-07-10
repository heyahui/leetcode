package y2019;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q021 {

    public static void main(String[] args) {
        System.out.println(new Q021().new Solution().isValid("(){}[]"));
    }

    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                    case ']':
                    case '}':
                        if (stack.size() == 0) {
                            return false;
                        } else {
                            char top = stack.pop();
                            if (c == ')') {
                                if (top == '(') {
                                    break;
                                } else {
                                    return false;
                                }
                            } else if (c == ']') {
                                if ('[' == top) {
                                    break;
                                } else {
                                    return false;
                                }
                            } else {
                                if ('{' == top) {
                                    break;
                                } else {
                                    return false;
                                }
                            }
                        }
                    default:
                        return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
