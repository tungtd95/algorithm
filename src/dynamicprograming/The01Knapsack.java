package dynamicprograming;

// { Driver Code Starts

import java.util.*;
import java.io.*;
import java.lang.*;

public class The01Knapsack {
    //Function to return max value that can be put in knapsack of capacity W.
    int[][] cache;

    public int knapSack(int W, int[] wt, int[] val, int n) {
        // your code here
        cache = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W + 1; j++) {
                cache[i][j] = -1;
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxValue = Integer.max(maxValue, findMaxInRange(wt, val, i, n - 1, W));
        }
        return maxValue;
    }

    private int findMaxInRange(int[] wt, int[] val, int start, int end, int weightToPick) {
        if (start == end) {
            if (wt[start] <= weightToPick) return val[start];
            else return 0;
        }
        if (wt[start] > weightToPick) return 0; // can pick start item because its weight is more than weight to pick
        if (cache[start][weightToPick] >= 0) return cache[start][weightToPick];

        int maxValueInRange = Integer.MIN_VALUE;
        for (int i = start + 1; i <= end; i++) {
            maxValueInRange = Integer.max(
                    maxValueInRange,
                    findMaxInRange(wt, val, i, end, weightToPick - wt[start])
            );
        }
        maxValueInRange += val[start];
        cache[start][weightToPick] = maxValueInRange;
        return maxValueInRange;
    }
}
