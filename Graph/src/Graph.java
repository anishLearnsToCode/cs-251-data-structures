import java.util.*;

public class Graph {
    private HashMap<Integer, Vertex> vertices;
    private int edges=0;

    //Constructors
    Graph(){
        vertices = new HashMap<>();
    }

    //Methods
    public boolean containsVertex(int vertexData){
        return vertices.containsKey(vertexData);
    }

    public void addVertex(int vertexData) throws AlreadyContainsVertexException{
        if(containsVertex(vertexData))
            throw new AlreadyContainsVertexException();

        Vertex vertex = new Vertex(vertexData);
        vertices.put(vertexData, vertex);
    }

    public void createEdge(int v1, int v2, Integer weight) throws VertexDoesNotExistException{
        if(!vertices.containsKey(v1) || !vertices.containsKey(v2))
            throw new VertexDoesNotExistException(vertices.containsKey(v1) ? v2 : v1);

        Edge edge = new Edge(vertices.get(v1), vertices.get(v2), weight);
        vertices.get(v1).addEdge(edge);
        vertices.get(v2).addEdge(edge);
        edges++;
    }
    public void createEdge(int v1, int v2) throws VertexDoesNotExistException{
        createEdge(v1, v2, null);
    }

    public boolean isConnected(int v1, int v2) throws VertexDoesNotExistException{
        if(!vertices.containsKey(v1) || !vertices.containsKey(v2))
            throw new VertexDoesNotExistException();

        return existsPathBetween(v1, v2);
    }
    private boolean existsPathBetween(int v1, int v2){
        HashSet<Vertex> processedVertices = new HashSet<>();
        return searchInForest(vertices.get(v1), vertices.get(v2), processedVertices);
    }
    private boolean searchInForest(Vertex main, Vertex search, HashSet<Vertex> processedVertices){
        if(main == search)
            return true;

        for(Edge edge : main.EdgeSet()){
            Vertex otherMain = edge.vertexFrom() == main ? edge.vertexTo() : edge.vertexFrom();
            if(!processedVertices.contains(otherMain)){
                processedVertices.add(otherMain);
                if(searchInForest(otherMain, search, processedVertices))
                    return true;
            }
        }
        return false;
    }

    //Graph Properties
    public int edges(){
        return edges;
    }
    public int vertices(){
        return vertices.size();
    }

    //Traversals
    //Depth First Search
    public void depthFirstSearch(){
        if(vertices() == 0) return;

        HashSet<Vertex> processedVertices = new HashSet<>();
        Vertex start = new Vertex();
        for(Map.Entry<Integer, Vertex> entry : vertices.entrySet()){
            start = entry.getValue();
            break;
        }
        depthFirstSearch(start, processedVertices);
        System.out.println();
    }
    private void depthFirstSearch(Vertex vertex, HashSet<Vertex> processedVertices){
        if(vertex == null){
            return;
        }
        if(processedVertices.contains(vertex)){
            return;
        }

        processedVertices.add(vertex);
        System.out.print(vertex.data() + " ");

        for(Edge edge : vertex.EdgeSet()){
            depthFirstSearch(edge.vertexFrom() == vertex ? edge.vertexTo() : edge.vertexFrom() ,
                    processedVertices);
        }
    }

    //Breadth First Search
    public void breadthFirstSearch(){
        if(vertices() == 0) return;

        HashSet<Vertex> processedVertices = new HashSet<>();
        Vertex start = new Vertex();
        for(Map.Entry<Integer, Vertex> entry : vertices.entrySet()){
            start = entry.getValue();
            break;
        }

        breadthFirstSearch(start, processedVertices);
        System.out.println();
    }
    private void breadthFirstSearch(Vertex vertex, HashSet<Vertex> processedVertices){
        LinkedList<Vertex> verticesList = new LinkedList<>();
        verticesList.add(vertex);

        while (!verticesList.isEmpty()){
            Vertex node = verticesList.pop();
            System.out.print(node.data() + " ");
            processedVertices.add(node);

            addAdjacent(node, verticesList, processedVertices);
        }
    }
    private void addAdjacent(Vertex vertex, LinkedList<Vertex> linkedList, HashSet<Vertex> processedVertices){
        for(Edge edge : vertex.EdgeSet()){
            Vertex otherVertex = edge.vertexFrom() == vertex ? edge.vertexTo() : edge.vertexFrom();
            if(!processedVertices.contains(otherVertex))
                linkedList.add(otherVertex);
        }
    }

    //Minimum Spanning Trees
    //Drijstal Algorithm


    //Printing
    public void print(){
        for(Map.Entry<Integer, Vertex> entry : vertices.entrySet()){
            System.out.print(entry.getKey() + " : ");
            print(entry.getValue().EdgeSet(), entry.getValue());
        }
    }
    private void print(HashSet<Edge> edgeSet, Vertex from){
        for(Edge edge : edgeSet){
            System.out.print( (edge.vertexFrom() == from ? edge.vertexTo().data() : edge.vertexFrom().data()) + " " );
        }
        System.out.println();
    }
}


class AlreadyContainsVertexException extends Exception{
    AlreadyContainsVertexException(){
        System.out.println("AlreadyContainsVertexException");
    }
}

class VertexDoesNotExistException extends Exception{
    VertexDoesNotExistException(){}
    VertexDoesNotExistException(int vertexData){
        System.out.println("VertexDoesNotExistException : " + vertexData);
    }
}