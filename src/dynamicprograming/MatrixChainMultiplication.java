package dynamicprograming;

// { Driver Code Starts
//Initial Template for Java

import test.UtilsKt;

import java.io.*;
import java.util.*;

class MatrixChainMultiplicationMain {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            MatrixChainMultiplication ob = new MatrixChainMultiplication();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

public class MatrixChainMultiplication {
    long[][] minCache;

    public long matrixMultiplication(int N, int[] arr) {
        // code here
        minCache = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minCache[i][j] = -1L;
            }
        }
        return matrixMulInRange(arr, 1, arr.length);
    }

    private long matrixMulInRange(int[] arr, int start, int end) {
        if (end == start + 1) return 0; // only one matrix
        if (minCache[start - 1][end - 1] >= 0) {
            return minCache[start - 1][end - 1]; // retrieve result from cache if existed
        }

        long minCost = Long.MAX_VALUE;
        for (int breakPoint = start + 1; breakPoint < end; breakPoint++) {
            long costLeft = matrixMulInRange(arr, start, breakPoint);
            long costRight = matrixMulInRange(arr, breakPoint, end);
            long costMid = (long) arr[start - 1] * arr[breakPoint - 1] * arr[end - 1];
            minCost = Long.min(minCost, costLeft + costMid + costRight);
        }
        minCache[start - 1][end - 1] = minCost;

//        UtilsKt.print2DArray(minCache);
        return minCost;
    }
}
