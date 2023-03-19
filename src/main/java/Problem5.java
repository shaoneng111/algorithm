/**
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 */
public class Problem5 {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;

        for (int l = 0; l <= len -1; l++) {
            dp[l][l] = true;
        }

        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) != s.charAt(r)) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l+1][r-1];
                    }
                }
                if (dp[l][r] && (r-l+1) > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    public static void main(String[] args) {

        String s1 = "babad";
        System.out.println(longestPalindrome(s1));

        String s2 = "cbbd";
        System.out.println(longestPalindrome(s2));

        String s3 = "ccc";
        System.out.println(longestPalindrome(s3));
    }
}
