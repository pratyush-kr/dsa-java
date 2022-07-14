import java.util.ArrayList;

import algorithms.DynamicProgramming;
/*
book example
    int[][] array = {
            { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
            { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
            { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
            { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
            { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
            { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
            { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
    };
*/

public class App {
    public static void subSeqSum(int i, ArrayList<Integer> ds, int sum, int s, int[] arr) {
        if (i >= arr.length) {
            if (s == sum) {
                System.out.println(ds);
            }
            return;
        }
        ds.add(arr[i]);
        s += arr[i];
        subSeqSum(i + 1, ds, sum, s, arr);
        ds.remove(ds.size() - 1);
        s -= arr[i];
        subSeqSum(i + 1, ds, sum, s, arr);
    }

    public static void subSeq(int i, ArrayList<Integer> ds, int[] arr) {
        if (i >= arr.length) {
            System.out.println(ds);
            return;
        }
        ds.add(arr[i]);
        subSeq(i + 1, ds, arr);
        ds.remove(ds.size() - 1);
        subSeq(i + 1, ds, arr);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        subSeqSum(0, new ArrayList<>(), 3, 0, arr);
        System.out.println("\n\n");
        subSeq(0, new ArrayList<>(), arr);
        // DynamicProgramming dp = new DynamicProgramming();
        // int[] arr = { 3, 4, 2, 2, 5, 1, 5, 7, 8, 4 };
        // ArrayList<Integer> array = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        // array.add(arr[i]);
        // }
        // System.out.println(dp.frogJumpK(10, 4, array));
    }
}