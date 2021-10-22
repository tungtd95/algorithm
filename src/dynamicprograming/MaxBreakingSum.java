package dynamicprograming;

import java.util.*;

public class MaxBreakingSum {

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int maxSum(int n) {
        if (n < 2) return n;
        if (cache.get(n) != null) return cache.get(n);
        int div2 = n / 2;
        int div3 = n / 3;
        int div4 = n / 4;
        int max = Integer.max(div2, maxSum(div2)) + Integer.max(div3, maxSum(div3)) + Integer.max(div4, maxSum(div4));
        cache.put(n, max);
        return max;
    }
}
