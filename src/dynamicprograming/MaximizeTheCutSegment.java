package dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class MaximizeTheCutSegment {

    long max = 0;

    // TOTO: find someway to cache
    public long maximizeCuts(int n, int x, int y, int z) {
        //Your code here
        List<Integer> uniqueSegments = filterUnique(x, y, z);
        if (uniqueSegments.size() == 0) return 0;
        if (uniqueSegments.size() == 1) {
            if (n % x == 0) return 1;
            else return 0;
        }

        // algorithm start here
        maximizeTheCutsInRange(uniqueSegments, 1, uniqueSegments.size(), n, 0);
        return max;
    }

    private void maximizeTheCutsInRange(List<Integer> segments, int start, int end, int n, long maxProgress) {
        if (n == 0) {
            max = Long.max(max, maxProgress);
            return;
        }
        if (n < 0) return;

        for (int i = start; i <= end; i++) {
            maximizeTheCutsInRange(segments, i, end, n - segments.get(i - 1), maxProgress + 1);
        }
    }

    private List<Integer> filterUnique(int x, int y, int z) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(x);
        if (y != x) result.add(y);
        if (z != x && z != y) result.add(z);
        return result;
    }
}
