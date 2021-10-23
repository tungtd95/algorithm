package dynamicprograming;

import test.UtilsKt;

import java.awt.*;
import java.io.*;
import java.util.*;

public class MaxPathMatrix {
    int cache[][];

    public int maximumPath(int N, int Matrix[][]) {
        int maxPath = 0;
        cache = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cache[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            maxPath = max(0, maxPath, findMaxForPos(Matrix, 0, i, N));
        }
        return maxPath;
    }

    private int findMaxForPos(int[][] matrix, int row, int column, int n) {
        if (column < 0 || column >= n) return 0;
        if (row == n - 1) return matrix[row][column];
        if (cache[row][column] >= 0) return cache[row][column];

        int currentPos = matrix[row][column];

        int maxPathLeft = findMaxForPos(matrix, row + 1, column - 1, n);
        int maxPathRight = findMaxForPos(matrix, row + 1, column + 1, n);
        int maxPathMiddle = findMaxForPos(matrix, row + 1, column, n);

        int result = max(maxPathMiddle, maxPathLeft, maxPathRight) + currentPos;
        cache[row][column] = result;

//        UtilsKt.print2DArray(cache);

        return result;
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}

/**
 * 2
 * 348 391 618 193
 *
 * 3
 * 6 7 4 7 6 1 3 5 7
 */