import java.util.*;

public class DFS {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    DFS(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                dfsUtil(adj, visited);
            }
        }
    }

    void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
    }

    public static void main(String[] args) {
        DFS graph = new DFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        System.out.println("Graph DFS starting from node 0:");
        graph.dfs(0);
    }
}