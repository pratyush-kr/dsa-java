package algorithms;

import java.util.ArrayList;

public class DynamicProgramming {
    /*
     * Climbing Stairs Problem
     * A pearson can either take one steps or two steps
     * to climb up in stairs find number of ways he can climb
     */
    public int climbingStairs(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return climbingStairs(n - 1) + climbingStairs(n - 2);
        }
    }

    public int climbingStairs(int n, int[] array) {
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public int climbingStairs(int n, int prev, int curr, int next) {
        prev = 1;
        curr = 1;
        next = 0;
        for (int i = 2; i <= n; i++) {
            next = curr + prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    private int abs(int a) {
        return (a < 0) ? -a : a;
    }

    private int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public int frogJump(int n, ArrayList<Integer> height) {
        int prev2, prev, curr, first, second = Integer.MAX_VALUE;
        prev = 0;
        curr = 0;
        prev2 = 0;
        for (int i = 1; i < n; i++) {
            first = prev + abs(height.get(i) - height.get(i - 1));
            if (i > 1) {
                second = prev2 + abs(height.get(i) - height.get(i - 2));
            }
            curr = min(first, second);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }

    private int fun(int n, int k, int minEnergy, ArrayList<Integer> height) {
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i <= k; i++) {
            if (n - i > 0) {
                int jump = this.frogJumpK(n - i, k, height) + abs(height.get(n) - height.get(n - i));
                minEnergy = min(jump, minEnergy);
            } else {
                break;
            }
        }
        return minEnergy;
    }

    public int frogJumpK(int n, int k, ArrayList<Integer> height) {
        return fun(n - 1, k, Integer.MAX_VALUE, height);
    }
}
