package algorithms;

public class QuickSort {
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int partition(int[] arr, int m, int p) {
        int v = arr[m];
        int i = m, j = p;
        do {
            do {
                i++;
            } while (arr[i] >= v);
            do {
                j--;
            } while (arr[j] <= v);
            if (i < j) {
                swap(arr, i, j);
            }
        } while (i >= j);
        arr[m] = arr[j];
        arr[j] = v;
        return j;
    }

    public void sort(int arr[], int p, int q) {
        if (p < q) {
            int j = partition(arr, p, q + 1);
            sort(arr, p, j - 1);
            sort(arr, j + 1, q);
        }
    }

    public static void driver() {
        QuickSort qs = new QuickSort();
        int[] arr = { -1, 0, 1, 5, 2, 4, 3, 7, 8, 9, 6, 100 };
        qs.sort(arr, 1, 10);
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
