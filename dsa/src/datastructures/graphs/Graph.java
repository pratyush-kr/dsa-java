package datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    protected int vertices;
    protected boolean isDirected;
    protected int[][] adjMat;
    protected int[] parent;

    private class Edge {
        int src;
        int dst;
        int weight;
    };

    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        adjMat = new int[vertices + 1][vertices + 1];
        this.isDirected = isDirected;
        parent = new int[vertices];
    }

    public Graph(int vertices, boolean isDirected, int[][] adjMat) {
        this.vertices = vertices;
        this.adjMat = adjMat;
        this.isDirected = isDirected;
        parent = new int[vertices];
    }

    public void createMatrix(int edges) {
        Scanner sc = new Scanner(System.in);
        if (isDirected) {
            edges = 2 * edges;
            while (edges-- != 0) {
                System.out.print("i: ");
                int i = sc.nextInt();
                System.out.print("j: ");
                int j = sc.nextInt();
                System.out.print(String.format("weight(edge[%d, %d]): ", i, j));
                this.adjMat[i][j] = sc.nextInt();
            }
            for (int i = 0; i < vertices; i++) {
                this.adjMat[i][i] = 0;
            }
        } else {
            while (edges-- != 0) {
                System.out.print("i: ");
                int i = sc.nextInt();
                System.out.print("j: ");
                int j = sc.nextInt();
                System.out.print(String.format("weight(edge[%d, %d]): ", i, j));
                this.adjMat[i][j] = sc.nextInt();
                this.adjMat[j][i] = this.adjMat[i][j];
            }
            for (int i = 0; i < vertices; i++) {
                this.adjMat[i][i] = 0;
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

    public static void driver() {
        System.out.print("vertices: ");
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        System.out.print("edges: ");
        int edges = sc.nextInt();
        System.out.print("isDirected: ");
        boolean isDirected = (sc.nextInt() == 1) ? true : false;
        Graph graph = new Graph(vertices, isDirected);
        graph.createMatrix(edges);
        System.out.println("Graph:");
        graph.printAdjMatrix();
        int start = 2;
        System.out.print("dfs: ");
        graph.dfs(start, new boolean[vertices + 1]);
        System.out.println();
        System.out.print("bfs: ");
        graph.bfs(start, new boolean[vertices + 1]);
        System.out.println();
        graph.connected();
        sc.close();
    }

    public void connected() {
        boolean visited[] = new boolean[vertices + 1];
        boolean isDisconnected = false;
        dfs(1, visited);
        for (int i = 1; i <= vertices; i++) {
            if (visited[i] == false) {
                System.out.println("Disconnected");
                isDisconnected = true;
                break;
            }
        }
        if (isDisconnected == false) {
            System.out.println("Connected");
        }
    }

    public void kruskal() {
        Edge edges[] = new Edge[vertices + 1];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                // edges[]
            }
        }
    }
}