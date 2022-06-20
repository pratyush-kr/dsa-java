package algorithms.array;

public class RangeSum {
    private int[] prefixArray;

    public RangeSum(Integer[] array) {
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
