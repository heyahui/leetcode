package y2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 *
 *  
 *
 * 提示：
 *
 * 1 <= N <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q054 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private Map<Integer, List<TreeNode>> cache = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int N) {
            if (!cache.containsKey(N)) {
                List<TreeNode> nodes = new ArrayList<>();
                if (N == 1) {
                    nodes.add(new TreeNode(0));
                } else if (N >> 1 << 1 != N) {
                    for (int x = 0; x < N; x++) {
                        int y = N - 1 - x;
                        for (TreeNode left : allPossibleFBT(x)) {
                            for (TreeNode right : allPossibleFBT(y)) {
                                TreeNode root = new TreeNode(0);
                                root.left = left;
                                root.right = right;
                                nodes.add(root);
                            }
                        }
                    }
                }
                cache.put(N, nodes);
            }
            return cache.get(N);
        }
    }
}
