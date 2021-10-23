package dynamicprograming;

public class CountNumberOfHops {
    final int modulo = 1000000007;
    long[] cache;

    // jump 1 2 or 3 step
    public long countWays(int n) {
        cache = new long[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return countWaysWithCache(n);
    }

    private long countWaysWithCache(int n) {
        // add your code here
        if (n < 0) return 0;
        if (n <= 1) return 1;
        if (cache[n - 1] >= 0) return cache[n - 1];

        long count1 = countWaysWithCache(n - 1);
        long count2 = countWaysWithCache(n - 2);
        long count3 = countWaysWithCache(n - 3);

        long result = (count1 + count2 + count3) % modulo;
        cache[n - 1] = result;
        return result;
    }
}
