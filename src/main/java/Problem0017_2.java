import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0017_2 {


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

    public static List<String> letterCombinations(String digits) {

        List<String> results = new ArrayList<>();
        int len = digits.length();
        results.add("");
        for (int i = 0; i < len; i++) {
            String phoneChar = phoneMap.get(digits.charAt(i));
            int size = results.size();
            for (int j = 0; j < size; j++) {
                String tmp = results.remove(0);
                for (int k = 0; k < phoneChar.length(); k++) {
                    results.add(tmp + phoneChar.charAt(k));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> results = letterCombinations(digits);
        System.out.println(results);
    }

}
