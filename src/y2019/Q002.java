package y2019;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author heyahui
 */
public class Q002 {

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return str2node(strAdd(node2str(l1), node2str(l2)));
        }

        private String strAdd(String str1, String str2) {
            StringBuilder builder = new StringBuilder();
            int max = str1.length() > str2.length() ? str1.length() : str2.length();
            int[] arr1 = new int[max];
            int[] arr2 = new int[max];
            int[] arr3 = new int[max + 1];
            for (int i = 0; i < str1.length(); i++) {
                arr1[i] = Integer.valueOf(str1.substring(i, i + 1));
            }
            for (int i = 0; i < str2.length(); i++) {
                arr2[i] = Integer.valueOf(str2.substring(i, i + 1));
            }
            for (int i = 0; i < max; i++) {
                int sum = arr1[i] + arr2[i] + arr3[i];
                if (sum >= 10) {
                    arr3[i] = sum - 10;
                    arr3[i + 1] = 1;
                } else {
                    arr3[i] = sum;
                }
            }
            for (int i : arr3) {
                builder.append(i);
            }
            if (String.valueOf(0).equals(builder.substring(max))) {
                return builder.substring(0, max);
            }
            return builder.toString();
        }

        private String node2str(ListNode node) {
            StringBuilder builder = new StringBuilder();
            builder.append(node.val);
            while (node.next != null) {
                builder.append(node.next.val);
                node = node.next;
            }
            return builder.toString();
        }

        private ListNode str2node(String str) {
            String[] arr = str.split("");
            ListNode start = new ListNode(Integer.valueOf(arr[0]));
            ListNode current = start;
            for (int i = 1; i < arr.length; i++) {
                current.next = new ListNode(Integer.valueOf(arr[i]));
                current = current.next;
            }
            return start;
        }
    }

    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int v1, v2, carry = 0;
            ListNode start, current;
            start = new ListNode(0);
            current = start;
            while (l1 != null || l2 != null) {
                v1 = l1 == null ? 0 : l1.val;
                v2 = l2 == null ? 0 : l2.val;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                int sum = v1 + v2 + carry;
                if (sum >= 10) {
                    carry = 1;
                    current.next = new ListNode(sum - 10);
                } else {
                    carry = 0;
                    current.next = new ListNode(sum);
                }
                current = current.next;
            }
            if (carry > 0) {
                current.next = new ListNode(1);
            }
            return start.next;
        }
    }

}
