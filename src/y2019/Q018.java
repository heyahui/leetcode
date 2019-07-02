package y2019;

/**
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
 *
 * 我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
 *
 * 我们先来回顾一下中位数的知识：
 *
 *     如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
 *     如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
 *
 * 示例 2：
 *
 * 输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
 *
 *
 *
 * 提示：
 *
 *     count.length == 256
 *     1 <= sum(count) <= 10^9
 *     计数表示的众数是唯一的
 *     答案与真实值误差在 10^-5 以内就会被视为正确答案
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/statistics-from-a-large-sample
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q018 {

    public static void main(String[] args) {
        new Q018().new Solution().sampleStats(new int[]{0, 0, 0, 0, 284});
    }

    // timeout
//    class Solution {
//        int minimum = 255;
//        int maximum;
//        double mean;
//        double median;
//        int mode;
//
//        public double[] sampleStats(int[] count) {
//            int c = count(count);
//            double sum = 0.0;
//            for (int i = 0; i < count.length; i++) {
//                if (count[i] > 0) {
//                    if (minimum > i) {
//                        minimum = i;
//                    }
//                    if (maximum < i) {
//                        maximum = i;
//                    }
//                    if (count[i] > count[mode]) {
//                        mode = i;
//                    }
//                    sum += count[i] * i;
//                }
//            }
//            mean = sum / c;
//            median = getMedian(count, c);
//            return new double[]{minimum, maximum, mean, median, mode};
//        }
//
//        private int count(int[] arr) {
//            int c = 0;
//            for (int i : arr) {
//                c += i;
//            }
//            return c;
//        }
//
//        private double getMedian(int[] arr, int count) {
//            double median;
//            int idx = 0;
//            if (count % 2 == 1) {
//                for (int i = 0; i < arr.length; i++) {
//                    if (arr[i] > 0) {
//                        for (int j = 0; j < arr[i]; j++) {
//                            if (idx++ == count / 2) {
//                                median = i;
//                                return median;
//                            }
//                        }
//                    }
//                }
//            } else {
//                median = 0.0;
//                for (int i = 0; i < arr.length; i++) {
//                    if (arr[i] > 0) {
//                        for (int j = 0; j < arr[i]; j++) {
//                            if (idx == count / 2 - 1) {
//                                median += i;
//                            } else if (idx == count / 2) {
//                                median += i;
//                                median /= 2;
//                                return median;
//                            }
//                            idx++;
//                        }
//                    }
//                }
//            }
//            return 0;
//        }
//    }

    class Solution {
        public double[] sampleStats(int[] count) {
            int mode = 0;
            int max = 0;
            int min = -1;
            double mean;
            double median = 0;
            int maxCount = 0;
            int totalCount = 0;
            double sum = 0.0;
            for (int i = 0; i < count.length; i++) {
                int repeat = count[i];
                if (repeat > 0) {
                    if (repeat > maxCount) {
                        maxCount = repeat;
                        mode = i;
                    }
                    if (i > max) {
                        max = i;
                    }
                    if (min == -1) {
                        min = i;
                    }
                    totalCount += repeat;
                    sum += i * repeat;
                }
            }
            mean = sum / totalCount;

            boolean isOdd = totalCount % 2 != 0;
            if (isOdd) {
                int total = 0;
                for (int i = 0; i < count.length; i++) {
                    int repeat = count[i];
                    if (repeat > 0) {
                        total += repeat;
                        if (total > totalCount >> 1) {
                            median = i;
                            break;
                        }
                    }
                }
            } else {
                int total = 0;
                for (int i = 0; i < count.length; i++) {
                    int repeat = count[i];
                    if (repeat > 0) {
                        total += repeat;
                        if (total >= totalCount >> 1) {
                            median = i;
                            if (total == totalCount >> 1) {
                                for (int j = i + 1; j < count.length; j++) {
                                    if (count[j] > 0) {
                                        median += j;
                                        median /= 2;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }

            return new double[]{min, max, mean, median, mode};
        }
    }

}
