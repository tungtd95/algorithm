package dynamicprograming;

// { Driver Code Starts

import test.UtilsKt;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LCS {
    //Function to find the length of longest common subsequence in two strings.
    int[][] cache;
    public int lcs(int x, int y, String s1, String s2) {
        // your code here
        cache = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cache[i][j] = -1;
            }
        }
        return lcsInRange(s1, s2, x - 1, y - 1);
    }

    private int lcsInRange(String s1, String s2, int pos1, int pos2) {
        if (pos1 == -1 || pos2 == -1) return 0;
        if (cache[pos1][pos2] >= 0) return cache[pos1][pos2];
        if (s1.charAt(pos1) == s2.charAt(pos2)) {
            int max = lcsInRange(s1, s2, pos1 - 1, pos2 - 1) + 1;
            cache[pos1][pos2] = max;
            return max;
        }
        int maxCommon = Integer.max(lcsInRange(s1, s2, pos1 - 1, pos2), lcsInRange(s1, s2, pos1, pos2 - 1));
        cache[pos1][pos2] = maxCommon;
        return maxCommon;
    }
}