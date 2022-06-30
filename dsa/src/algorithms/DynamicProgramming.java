package algorithms;

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
}
