package algorithms.array;

public class BalancingArray {
    private Integer[] array;

    public BalancingArray(Integer[] array) {
        this.array = array;
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
}