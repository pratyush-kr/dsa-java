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

    public int frogJumpK(int n, int k, ArrayList<Integer> height) {
        int[] dp = new int[n + 1];
        int jumpEnergy = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j < k; j++) {
                if (i - j > 0) {
                    jumpEnergy = dp[i - j] + abs(height.get(i) - height.get(i - j));
                    minSteps = min(jumpEnergy, minSteps);
                }
                dp[i] = minSteps;
            }
        }
        return dp[n - 1];
    }
}
