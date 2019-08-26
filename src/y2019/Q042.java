package y2019;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q042 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return recursiveCall(nums, 0, nums.length - 1);
        }

        private TreeNode recursiveCall(int[] nums, int start, int end) {
            if (start == end) {
                return new TreeNode(nums[start]);
            } else {
                int maxIdx = start;
                for (int i = start + 1; i <= end; i++) {
                    if (nums[i] > nums[maxIdx]) {
                        maxIdx = i;
                    }
                }
                TreeNode root = new TreeNode(nums[maxIdx]);
                if (start == maxIdx) {
                    root.right = recursiveCall(nums, maxIdx + 1, end);
                } else if (end == maxIdx) {
                    root.left = recursiveCall(nums, start, maxIdx - 1);
                } else {
                    root.left = recursiveCall(nums, start, maxIdx - 1);
                    root.right = recursiveCall(nums, maxIdx + 1, end);
                }
                return root;
            }
        }
    }
}
