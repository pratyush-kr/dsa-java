package algorithms.array;

public class Array extends QuickSort {
    private int[] array;
    private int d;
    private int n;
    private int[] prefixArray;
    public int res;

    public Array(int[] array) {
        this.array = array;
        this.n = array.length;
        this.prefixArray = new int[n];
        for (int i = 1; i < n; i++) {
            prefixArray[i] += prefixArray[i - 1] + array[i];
        }
        res = 1;
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
        res = 1;
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

    public Integer rangeSum(int left, int right) {
        Integer ans = 0;
        if (left == 0) {
            ans = prefixArray[right];
        } else {
            ans = prefixArray[right] - prefixArray[left - 1];
        }
        return ans;
    }

    private boolean isAsc() {
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    private boolean isDesc() {
        for (int i = 0; i < n - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }

    public boolean isSorted() {
        return isAsc() || isDesc();
    }

    public int[] removeDuplicatesFromSortedArray() {
        if (isSorted() == false)
            return array;
        res = 1;
        for (int i = 1; i < n - 1; i++) {
            if (array[i] != array[res - 1]) {
                array[res++] = array[i];
            }
        }
        return array;
    }

    public int[] moveZerosToEnd() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                swap(i, count);
                count++;
            }
        }
        return array;
    }

    public int getSecondLargestElement() {
        int idx = -1;
        int largest = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] > array[largest]) {
                idx = largest;
                largest = i;
            } else if (array[i] < array[largest]) {
                if (idx == -1 || array[i] > array[idx]) {
                    idx = i;
                }
            }
        }
        return array[idx];
    }
}
