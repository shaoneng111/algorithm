import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 */
public class Problem0017 {

    private static Map<Character, String> phoneMap = new HashMap<Character, String>();

    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public static void backtrace(List<String> results, int index, String digits, StringBuilder result) {
        if (index == digits.length()) {
            results.add(result.toString());
        } else {
            String phoneChar = phoneMap.get(digits.charAt(index));
            for (int i = 0; i < phoneChar.length(); i++) {
                result.append(phoneChar.charAt(i));
                backtrace(results, index+1, digits, result);
                result.deleteCharAt(index);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        backtrace(results, 0, digits, new StringBuilder());
        return results;
    }



    public static void main(String[] args) {
        String digits = "23";
        List<String> results = letterCombinations(digits);
        System.out.println(results);
    }

}
