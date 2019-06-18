package y2019;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author heyahui
 */
public class Q001 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Q001 q1 = new Q001();
        int[] ints = q1.new Solution().twoSum(nums, target);
        assert ints[0] == 0 && ints[1] == 1;
        int[] ints2 = q1.new Solution2().twoSum(nums, target);
        assert ints2[0] == 0 && ints2[1] == 1;
        int[] ints3 = q1.new Solution3().twoSum(nums, target);
        assert ints3[0] == 0 && ints3[1] == 1;
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(target - nums[i])) {
                    return new int[]{list.indexOf(target - nums[i]), i};
                } else {
                    if (i != nums.length - 1) {
                        list.add(nums[i]);
                    }
                }
            }
            throw new IllegalArgumentException();
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int firstIndex = findFirstIndex(nums, i, target - nums[i]);
                if (firstIndex != -1) {
                    return new int[]{firstIndex, i};
                }
            }
            throw new IllegalArgumentException();
        }

        private int findFirstIndex(int[] nums, int maxIndex, int target) {
            for (int i = 0; i < maxIndex; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            // 为 map 指定容量和扩容因子能优化性能
            HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1.0f);
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];
                if (map.containsKey(current)) {
                    return new int[]{map.get(current), i};
                } else {
                    map.put(target - nums[i], i);
                }
            }
            throw new IllegalArgumentException();
        }
    }

}
