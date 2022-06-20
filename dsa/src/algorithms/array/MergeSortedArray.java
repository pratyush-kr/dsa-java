package algorithms.array;

public class MergeSortedArray {
    private Integer[] arr1;
    private Integer[] arr2;

    public MergeSortedArray(Integer[] arr1, Integer[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public Integer[] getMergedArray() {
        int n1, n2, n;
        n1 = arr1.length;
        n2 = arr2.length;
        n = n1 + n2;
        Integer[] array = new Integer[n];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                array[k] = arr1[i];
                k++;
                i++;
            } else {
                array[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < n1) {
            array[k] = arr1[i];
            k++;
            i++;
        }
        while (j < n2) {
            array[k] = arr2[j];
            k++;
            j++;
        }
        return array;
    }
}
