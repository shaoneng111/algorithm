import java.util.LinkedList;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 *
 *
 */
public class Problem0020 {

    public static boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                linkedList.push(tmp);
            } else {
                if (linkedList.size() <= 0) {
                    return false;
                }
                char popChar = linkedList.pop();
                if (popChar == '(' && tmp != ')') {
                    return false;
                } else if (popChar == '[' && tmp != ']') {
                    return false;
                } else if (popChar == '{' && tmp != '}') {
                    return false;
                }
            }
        }
        return linkedList.size() == 0;
    }

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(isValid(s1));

        String s2 = "()[]{}";
        System.out.println(isValid(s2));

        String s3 = "(";
        System.out.println(isValid(s3));
    }

}
