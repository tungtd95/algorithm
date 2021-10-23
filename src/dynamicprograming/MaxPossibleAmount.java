package dynamicprograming;

import java.util.ArrayList;

public class MaxPossibleAmount {
    public int maxAmount(int[] arr, int n) {
        //code here.
        return findMaxAmount(arr, 0, n - 1, true);
    }

    private int findMaxAmount(int[] input, int start, int end, boolean isFirstTurn) {
        if (start == end) {
            if (isFirstTurn)
                System.out.println("start = " + start + ", end = " + end + ", max = " + input[start]);
            if (isFirstTurn) return input[start];
            else return 0;
        }

        int maxFirst = input[start] + findMaxAmount(input, start + 1, end, !isFirstTurn);
        if (isFirstTurn) {
            System.out.println("start+1 = " + (start + 1) + ", end = " + end + ", input[start] = " + input[start]);
        }
        int maxLast = input[end] + findMaxAmount(input, start, end - 1, !isFirstTurn);
        if (isFirstTurn)
            System.out.println("start = " + (start) + ", end-1 = " + (end - 1) + ", input[end] = " + input[end]);

        if (isFirstTurn) {
            return Integer.max(maxFirst, maxLast);
        } else {
            return 0;
        }
    }
}
