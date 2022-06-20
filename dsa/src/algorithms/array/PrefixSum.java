package algorithms.array;

public class PrefixSum {
    public static Integer[] prefixSum(Integer[] array) {
        int n = array.length;
        int prevSum = 0;
        for (int i = 0; i < n; i++) {
            prevSum += array[i];
            array[i] = prevSum;
        }
        return array;
    }
}
