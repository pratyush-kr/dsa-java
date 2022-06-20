package algorithms.array;

import java.util.Scanner;

public class PrefixSumProblem {
    public static Integer[] prefixSumProblem(Integer[] array, int m) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            array[a] = 100;
            array[b + 1] = -100;
        }
        int prevSum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            prevSum += array[i];
            array[i] = prevSum;
        }
        sc.close();
        return array;
    }
}
