package y2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * 提示：
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q007 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            int[] arr = new int[1];
            ArrayList<Integer> list = new ArrayList<>();
            iter(root, list);
            list.forEach(integer -> {
                if (integer >= L && integer <= R) {
                    arr[0] += integer;
                }
            });
            return arr[0];
        }

        private void iter(TreeNode root, List<Integer> list) {
            if (root != null) {
                list.add(root.val);
                iter(root.left, list);
                iter(root.right, list);
            }
        }
    }

    class Solution2 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            int sum = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (L <= node.val && R >= node.val) {
                        sum += node.val;
                    }
                    if (node.left != null && node.val > L) {
                        stack.push(node.left);
                    }
                    if (node.right != null && node.val < R) {
                        stack.push(node.right);
                    }
                }
            }
            return sum;
        }
    }

    class Solution3 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            } else {
                if (root.val > R) {
                    return rangeSumBST(root.left, L, R);
                } else if (root.val < L) {
                    return rangeSumBST(root.right, L, R);
                } else {
                    return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
                }
            }
        }
    }

}
