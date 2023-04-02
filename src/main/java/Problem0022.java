import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class Problem0022 {




    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        trace(list, n, n, "");
        return list;
    }

    private static void trace(List<String> results, int left, int right, String sb) {
        if (left == 0 && right == 0) {
            results.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            trace(results, left-1, right, sb+'(');
        }
        if (right > 0) {
            trace(results, left, right-1, sb+')');
        }
    }

    public static void main(String[] args) {
        List<String> str1 = generateParenthesis(2);
        System.out.println(str1);
//        List<String> str2 = generateParenthesis(1);
//        System.out.println(str2);
    }
}
