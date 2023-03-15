import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 *
 */
public class Problem3 {

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> hashSet = new HashSet<>();
        while (end < s.length()) {
            if (hashSet.contains(s.charAt(end))) {
                hashSet.remove(s.charAt(start));
            } else {
                hashSet.add(s.charAt(end));
            }
        }
    }

    public static void main(String[] args) {

    }
}
