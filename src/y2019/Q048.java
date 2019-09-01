package y2019;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q048 {
    class Solution {
        private List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            recursiveCall(nums, 0);
            return ret;
        }

        private void recursiveCall(int[] nums, int idx) {
            if (idx != nums.length) {
                for (int i = idx; i < nums.length; i++) {
                    swap(nums, idx, i);
                    recursiveCall(nums, idx + 1);
                    swap(nums, idx, i);
                }
            } else {
                List<Integer> toAdd = new ArrayList<>();
                for (int num : nums) {
                    toAdd.add(num);
                }
                ret.add(toAdd);
            }
        }

        private void swap(int[] nums, int idx1, int idx2) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }
    }
}
