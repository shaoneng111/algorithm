package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer10_2 {

    public int fib(int n) {
        Map<Integer, Integer> fibMap = new HashMap<>();
        fibMap.put(0, 0);
        fibMap.put(1, 1);
        if (n < 2) {
            return fibMap.get(n);
        }
        for (int i = 2; i <= n; i++) {
            int tmp = (fibMap.get(i-1) + fibMap.get(i-2))  % 1000000007;
            fibMap.put(i, tmp);
        }
        return fibMap.get(n);
    }
}
