package y2019;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q016 {

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int j = 0;
                while (true) {
                    if (nums1[i] == nums2[j++]) {
                        break;
                    }
                }
                res[i] = -1;
                for (; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        res[i] = nums2[j];
                        break;
                    }
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> idxMap = new HashMap<>(nums2.length, 1.0f);
            for (int i = 0; i < nums2.length; i++) {
                idxMap.put(nums2[i], i);
            }
            for (int i = 0; i < nums1.length; i++) {
                int current = nums1[i];
                nums1[i] = -1;
                int idx = idxMap.get(current) + 1;
                for (; idx < nums2.length; idx++) {
                    if (nums2[idx] > current) {
                        nums1[i] = nums2[idx];
                        break;
                    }
                }
            }
            return nums1;
        }
    }

}
