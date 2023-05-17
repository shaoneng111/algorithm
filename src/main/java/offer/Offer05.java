package offer;

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 */
public class Offer05 {

    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        String repStr = "%20";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(repStr);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
