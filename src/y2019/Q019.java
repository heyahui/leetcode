package y2019;

import java.util.Arrays;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q019 {

    class MinStack {

        int min = Integer.MAX_VALUE;

        int currentSize;

        int maxSize;

        int[] arr;

        /** initialize your data structure here. */
        public MinStack() {
            arr = new int[4];
            maxSize = 4;
            currentSize = 0;
        }

        public void push(int x) {
            arr[currentSize++] = x;
            min = min < x ? min : x;
            if (currentSize == maxSize) {
                maxSize *= 2;
                arr = Arrays.copyOf(arr, maxSize);
            }
        }

        public void pop() {
            int toPop = arr[currentSize - 1];
            arr[--currentSize] = 0;
            if (toPop == min) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < currentSize; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                }
            }
        }

        public int top() {
            return arr[currentSize - 1];
        }

        public int getMin() {
            return min;
        }

    }

}
