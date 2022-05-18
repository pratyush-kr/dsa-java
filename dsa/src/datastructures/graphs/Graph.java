package datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    protected int vertices;
    protected boolean isDirected;
    protected int[][] adjMat;

    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        adjMat = new int[vertices + 1][vertices + 1];
        this.isDirected = isDirected;
    }

    public Graph(int vertices, boolean isDirected, int[][] adjMat) {
        this.vertices = vertices;
        this.adjMat = adjMat;
        this.isDirected = isDirected;
    }

    public void createMatrix() {
        Scanner sc = new Scanner(System.in);
        if (isDirected) {
            for (int i = 1; i < vertices + 1; i++) {
                for (int j = 1; j < vertices + 1; j++) {
                    this.adjMat[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < vertices; i++) {
                this.adjMat[i][i] = 0;
            }
        } else {
            for (int i = 1; i <= vertices - 1; i++) {
                for (int j = 1 + i; j <= vertices; j++) {
                    System.out.print(String.format("weight(edge[%d, %d]): ", i, j));
                    this.adjMat[i][j] = sc.nextInt();
                    this.adjMat[j][i] = this.adjMat[i][j];
                }
            }
        }
        sc.close();
    }

    public void printAdjMatrix() {
        System.err.print("  ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print("__");
        }
        System.out.println();
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + "|");
            for (int j = 1; j <= vertices; j++) {
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int start, boolean[] visited) {

        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 1; i <= vertices; i++) {
            if (adjMat[start][i] >= 1 && visited[i] == false) {
                dfs(i, visited);
            }
        }
    }

    public void bfs(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (queue.isEmpty() == false) {
            int front = queue.remove();
            System.out.print(front + " ");
            for (int i = 1; i <= vertices; i++) {
                if (adjMat[front][i] >= 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}