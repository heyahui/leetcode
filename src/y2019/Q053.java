package y2019;

/**
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
 *  
 *
 * 提示：
 *
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Yahui
 */
public class Q053 {
    public static void main(String[] args) {
        int count = new Q053().new Solution().numTilePossibilities("ABAB");
        System.out.println(count);
    }

    class Solution {

        public int numTilePossibilities(String tiles) {
            int[] map = new int[26];
            for (char c : tiles.toCharArray()) {
                map[c - 'A']++;
            }
            return dfs(map);
        }

        private int dfs(int[] map) {
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    map[i]--;
                    count += dfs(map);
                    map[i]++;
                    count++;
                }
            }
            return count;
        }
    }
}
