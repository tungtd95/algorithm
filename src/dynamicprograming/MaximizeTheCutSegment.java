package dynamicprograming;

public class MaximizeTheCutSegment {
    int[] cache;

    public int maximizeCuts(int n, int x, int y, int z) {
        //Your code here
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        if (x == y && y == z) {
            if (n % x == 0) return n / x;
            else return 0;
        }
        int result = findMax(n, x, y, z, min(x, y, z));
        if (result < 0) result = 0;
        return result;
    }

    private int findMax(int n, int x, int y, int z, int min) {
        if (n == min) return 1;
        if (n < min) return Integer.MIN_VALUE;
        if (cache[n - 1] >= 0) return cache[n - 1];
        int result = max(findMax(n - x, x, y, z, min), findMax(n - y, x, y, z, min), findMax(n - z, x, y, z, min)) + 1;
        cache[n - 1] = result;
        return result;
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    private int min(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }
}
