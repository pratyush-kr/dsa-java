import algorithms.Recursion;

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
    public static void main(String[] args) {
        Recursion rs = new Recursion();
        rs.towerOfHanoi(3, 'A', 'B', 'C');
    }
}