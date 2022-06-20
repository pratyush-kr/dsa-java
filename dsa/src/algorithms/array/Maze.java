package algorithms.array;

public class Maze {
    private int[][] array;
    public int[][] path;

    public Maze(int[][] array) {
        this.array = array;
        int n = array.length;
        int m = array[0].length;
        path = new int[n][m];
    }

    private boolean isSafe(int x, int y) {
        int n = array.length;
        int m = array[0].length;
        if (x == -1 || x == n || y == -1 || y == m || path[x][y] == 2 || array[x][y] == 1) {
            return false;
        }
        return true;
    }

    public boolean findPath(int x, int y) {
        int n = array.length;
        int m = array[0].length;
        if (x == n - 1 && y == m - 1) {
            path[x][y] = 2;
            return true;
        }
        if (isSafe(x, y) == true) {
            path[x][y] = 2;
            if (findPath(x - 1, y - 1))
                return true;
            if (findPath(x - 1, y))
                return true;
            if (findPath(x - 1, y + 1))
                return true;
            if (findPath(x, y - 1))
                return true;
            if (findPath(x, y + 1))
                return true;
            if (findPath(x + 1, y - 1))
                return true;
            if (findPath(x + 1, y))
                return true;
            if (findPath(x + 1, y + 1))
                return true;
            path[x][y] = 0;
            return false;
        }
        return false;
    }
}
