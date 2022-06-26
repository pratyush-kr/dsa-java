package algorithms;

import java.util.ArrayList;

import algorithms.array.Array;

public class Recursion extends Array {
    private ArrayList<String> subStrings;

    public ArrayList<String> getSubStrings() {
        return subStrings;
    }

    public void setSubStrings(ArrayList<String> subStrings) {
        this.subStrings = subStrings;
    }

    public Recursion(int[] array) {
        super(array);
        subStrings = new ArrayList<>();
    }

    public Recursion() {
        super();
        subStrings = new ArrayList<>();
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

    public ArrayList<String> powerSet(String str, int index, String curr) {
        int n = str.length();
        if (index == n) {
            // System.out.println(curr);
            subStrings.add("'"+curr+"'");
            return subStrings;
        }
        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);
        return subStrings;
    }
}
