package dynamicprograming;

import java.awt.*;
import java.io.*;
import java.util.*;

class MaxPathMatrixMain {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for (int i = 0; i < N * N; i++)
                Matrix[(i / N)][i % N] = Integer.parseInt(input_line[i]);

            MaxPathMatrix ob = new MaxPathMatrix();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

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

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(cache[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(">>>>>>>>><<<<<<<<");

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