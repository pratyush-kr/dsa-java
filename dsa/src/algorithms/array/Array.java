package algorithms.array;

public class Array {
    private int[] array;
    private int d;
    private int n;
    private int[] prefixArray;

    public Array(int[] array) {
        this.array = array;
        this.n = array.length;
        this.prefixArray = new int[n];
    }

    public Array(int[] array, int d) {
        this.array = array;
        this.d = d;
        this.n = array.length;
    }

    public int getBalancePoint() {
        int sum = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += array[i];
            if (leftSum == (sum - leftSum)) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public int[] reverse() {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
        return this.array;
    }

    private void reverse(int left, int right) {
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
    }

    public int[] rotateLeft() {
        reverse(0, d - 1);
        reverse(d, n - 1);
        reverse(0, n - 1);
        return this.array;
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

    public static Integer[] prefixSum(Integer[] array) {
        int n = array.length;
        int prevSum = 0;
        for (int i = 0; i < n; i++) {
            prevSum += array[i];
            array[i] = prevSum;
        }
        return array;
    }

    public void RangeSum(Integer[] array) {
        int n = array.length;
        prefixArray = new int[n];
        prefixArray[0] = array[0];
        for (int i = 1; i < n; i++) {
            prefixArray[i] += prefixArray[i - 1] + array[i];
        }
    }

    public Integer rangeSum(int left, int right) {
        Integer ans = 0;
        if (left == 0) {
            ans = prefixArray[right];
        } else {
            ans = prefixArray[right] - prefixArray[left - 1];
        }
        return ans;
    }
}
