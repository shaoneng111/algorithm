import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * <p>
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
public class Problem3 {

    public static int lengthOfLongestSubstring(String s) {
        int maxSubLen = 0;
        Set<Character> hashSet = new HashSet<>();
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            while (end < s.length()) {
                if (hashSet.contains(s.charAt(end))) {
                    break;
                }
                hashSet.add(s.charAt(end));
                end++;
            }
            maxSubLen = Math.max(maxSubLen, end - i);
            hashSet.remove(s.charAt(i));
        }
        return maxSubLen;
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str1));
        String str2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(str2));
        String str3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str3));
        String str4 = "dvdf";
        System.out.println(lengthOfLongestSubstring(str4));
    }
}
