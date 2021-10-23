package dynamicprograming;// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//User function Template for Java
public class Fibonacci {
    long firstNumb = 1L;
    long secondNumb = 1L;
    int modulo = 1000000007;

    public long nthFibonacci(long n) {
        // code here
        if (n <= 2) return 1L;
        for (int i = 3; i <= n; i++) {
            long nextNumb = firstNumb + secondNumb;
            firstNumb = secondNumb % modulo;
            secondNumb = nextNumb % modulo;
        }

        return secondNumb;
    }
}
