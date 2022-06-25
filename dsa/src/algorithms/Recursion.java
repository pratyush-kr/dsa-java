package algorithms;

import algorithms.array.Array;

public class Recursion extends Array {
    public Recursion(int[] array) {
        super(array);
    }

    public Recursion() {
        super();
    }

    public boolean search(int left, int x) {
        if (left < n) {
            if (array[left] == x) {
                return true;
            } else {
                return search(left + 1, x);
            }
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String str, int left, int right) {
        if (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                return isPalindrome(str, left + 1, right - 1);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
