package y2019;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q012 {

    public static void main(String[] args) {
        new Q012().new Solution2().subsets(new int[]{1, 2, 3});
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < 1 << nums.length; i++) {
                List<Integer> il = new ArrayList<>();
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                for (int j = s.length(); j < nums.length; j++) {
                    s.insert(0, '0');
                }
                char[] chars = s.toString().toCharArray();
                for (int i1 = 0; i1 < chars.length; i1++) {
                    if (chars[i1] == '1') {
                        il.add(nums[i1]);
                    }
                }
                res.add(il);
            }
            return res;
        }
    }

    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int max = 1 << nums.length;
            for (int i = 0; i < max; i++) {
                List<Integer> il = new ArrayList<>();
                for (int j = 0, k = 1; j < nums.length; ++j, k <<= 1) {
                    if ((k & i) == k) {
                        il.add(nums[j]);
                    }
                }
                res.add(il);
            }
            return res;
        }
    }

    class Solution3 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int num : nums) {
                for (List<Integer> re : new ArrayList<>(res)) {
                    List<Integer> newList = new ArrayList<>(re);
                    newList.add(num);
                    res.add(newList);
                }
            }
            return res;
        }
    }

    class Solution4 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            inOrder(nums, 0, res, new ArrayList<>());
            return res;
        }

        private void inOrder(int[] nums, int idx, List<List<Integer>> res, List<Integer> subset) {
            if (idx != nums.length) {
                subset = new ArrayList<>(subset);
                inOrder(nums, idx + 1, res, subset);
                subset.add(nums[idx]);
                res.add(subset);
                inOrder(nums, idx + 1, res, subset);
            }
        }
    }

}
