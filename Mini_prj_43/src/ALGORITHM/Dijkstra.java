package ALGORITHM;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(int[][] graph, int source) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minDistance(distances, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }

        printSolution(distances);
    }

    private static int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int numVertices = distances.length;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printSolution(int[] distances) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}

