import java.util.Scanner;

public class GraphImplementation {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws AlreadyContainsVertexException, VertexDoesNotExistException {
        Graph graph = new Graph();

        graph.addVertex(10);    graph.addVertex(20);
        graph.addVertex(77);
        graph.createEdge(10, 20, 100);

        graph.addVertex(30);    graph.addVertex(40);
        graph.addVertex(50);    graph.addVertex(60);
        graph.createEdge(30, 40, 12);
        graph.createEdge(30, 50, 33);
        graph.createEdge(30, 60, 100);
        graph.createEdge(10, 60, 47);
        System.out.println("Graph ");
        graph.print();

        System.out.println("\nDepth First Search (DFS) :- ");
        graph.depthFirstSearch();

        System.out.println("\nBreadth First Search :- ");
        graph.breadthFirstSearch();

        System.out.println("\nNumber of Vertices : " + graph.vertices());
        System.out.println("Number of Edges : " + graph.edges());

        System.out.println(graph.isConnected(10, 30));
        System.out.println(graph.isConnected(10, 77));
    }
}
