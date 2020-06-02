import java.util.HashSet;

public class Vertex {
    private Integer data;
    private HashSet<Edge> edgeSet;

    //Constructors
    Vertex(){
        edgeSet = new HashSet<>();
    }
    Vertex(int data){
        this.data = data;
        edgeSet = new HashSet<>();
    }

    //Methods
    public void addEdge(Edge edge){
        edgeSet.add(edge);
    }
    public int degree(){
        return edgeSet.size();
    }

    //Getter Methods
    public int data(){
        return data;
    }
    public HashSet<Edge> EdgeSet() {
        return edgeSet;
    }
}


class Edge{
    private Vertex vertex1, vertex2;
    private Integer weight;

    //Constructors
    Edge(){}
    Edge(int weight){
        this.weight = weight;
    }
    Edge(Vertex vertex1, Vertex vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
    Edge(Vertex vertex1, Vertex vertex2, Integer weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    //Getter Methods
    public int weight(){
        return weight;
    }
    public Vertex vertexFrom() {
        return vertex1;
    }

    public Vertex vertexTo() {
         return vertex2;
    }
}