package algorithms.array;

public class LargestSumSubArray {
    public Integer[] array;

    public LargestSumSubArray(Integer[] array) {
        this.array = array;
    }

    public int getLargestSumSubArray() {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = Integer.MAX_VALUE;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            max_ending_here += array[i];
            max_so_far = (max_so_far > max_ending_here) ? max_so_far : max_ending_here;
            max_ending_here = (max_ending_here < 0) ? 0 : max_ending_here;
        }
        return max_so_far;
    }
}
