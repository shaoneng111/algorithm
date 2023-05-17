package meeting;


import java.util.ArrayList;
import java.util.List;

/**
 * n以内所有所有组合
 * n = 3
 * [[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
 *
 */
public class NTravel {


    public static List<List<Integer>> getNResult(int n) {
        if (n == 1) {
            return getNList(1);
        } else {
            List<List<Integer>> preResult = getNResult(n-1);
            List<List<Integer>> result = getNList(n);
            result.addAll(preResult);
            for (List<Integer> tmp : preResult) {
                List<Integer> k = new ArrayList<>(tmp);
                k.add(n);
                result.add(k);
            }
            return result;
        }
    }


    public static List<List<Integer>> getNList(int n) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(n);
        List<List<Integer>> result = new ArrayList<>();
        result.add(tmp);
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> list = getNResult(4);
        System.out.println(list);
    }
}
