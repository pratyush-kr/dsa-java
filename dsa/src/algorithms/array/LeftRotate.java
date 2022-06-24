package algorithms.array;

public class LeftRotate {
    private int[] array;
    private int d;
    private int n;

    public LeftRotate(int[] array, int d) {
        this.array = array;
        this.d = d;
        this.n = array.length;
    }

    private void reverse(int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
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
}
