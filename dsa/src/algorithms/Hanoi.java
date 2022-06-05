package algorithms;

public class Hanoi {
    public static void solve(int disk, int src, int des, int aux) {
        if (disk == 0) {
            return;
        }
        solve(disk - 1, src, aux, des); // move disk from src to aux
        System.out.println(String.format("Move Disk %s from %s to %s", disk, src, des));
        solve(disk - 1, aux, des, src); // move disk from aux to src
    }
}
