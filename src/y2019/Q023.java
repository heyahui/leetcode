package y2019;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q023 {

    class KthLargest {

        int[] heap;
        int pt = 0;

        public KthLargest(int k, int[] nums) {
            heap = new int[k];
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pt != heap.length) {
                push(val);
            } else if (val > peek()) {
                pop();
                push(val);
            }
            return peek();
        }

        private void push(int v) {
            heap[pt] = v;
            pt++;
            shiftUp(pt - 1);
        }

        private void shiftUp(int idx) {
            if (idx != 0) {
                int pIdx = (idx - 1) / 2;
                int p = heap[pIdx];
                int c = heap[idx];
                if (p > c) {
                    heap[idx] = p;
                    heap[pIdx] = c;
                    shiftUp(pIdx);
                }
            }
        }

        private int peek() {
            return heap[0];
        }

        private void shiftDown(int idx) {
            int lIdx = idx * 2 + 1;
            int rIdx = idx * 2 + 2;
            int p = heap[idx];
            if (heap.length - 1 >= rIdx) {
                int lc = heap[lIdx];
                int rc = heap[rIdx];
                int c = lc < rc ? lc : rc;
                int cIdx = lc < rc ? lIdx : rIdx;
                if (p > c) {
                    heap[idx] = c;
                    heap[cIdx] = p;
                    shiftDown(cIdx);
                }
            } else if (heap.length - 1 == lIdx) {
                int c = heap[lIdx];
                int cIdx = lIdx;
                if (p > c) {
                    heap[idx] = c;
                    heap[cIdx] = p;
                }
            }
        }

        private int pop() {
            int top = heap[0];
            heap[0] = heap[pt - 1];
            pt--;
            shiftDown(0);
            return top;
        }
    }

}
