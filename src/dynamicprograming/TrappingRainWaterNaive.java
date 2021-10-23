package dynamicprograming;

public class TrappingRainWaterNaive {

    public long trappingWater(int[] arr, int n) {
        int start = findNewStart(arr, 0, n - 1);
        int end =  findNewEnd(arr, 0, n - 1);
        long sum = 0;

        while (true) {
            if (start == end || start == end - 1) break;
            if (start < 0 || end < 0) break;
            int currentMin = findMin(arr, start, end);
            int zeroCount = countZero(arr, start, end);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("start = " + start + ", end = " + end + ", min = " + currentMin + ", zeroCount = " + zeroCount);
            sum += (long) currentMin * zeroCount;
            minusArr(arr, start, end, currentMin);
            int newStart = findNewStart(arr, start, end);
            int newEnd = findNewEnd(arr, start, end);
            start = newStart;
            end = newEnd;
        }

        return sum;
    }

    private int findNewStart(int[] arr, int currentStart, int currentEnd) {
        for (int i = currentStart; i <= currentEnd; i++) {
            if (arr[i] != 0) return i;
        }
        return -1;
    }

    private int findNewEnd(int[] arr, int currentStart, int currentEnd) {
        for (int i = currentEnd; i >= currentStart; i--) {
            if (arr[i] != 0) return i;
        }
        return -1;
    }

    private int findMin(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] != 0) {
                min = Integer.min(min, arr[i]);
            }
        }
        return min;
    }

    private int countZero(int[] arr, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == 0) count++;
        }
        return count;
    }

    private void minusArr(int[] arr, int start, int end, int minus) {
        for (int i = start; i <= end; i++) {
            arr[i] = arr[i] - minus;
            if (arr[i] < 0) arr[i] = 0;
        }
    }
}
