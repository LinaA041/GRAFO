package model;

public interface GraphInterface <T> {


   // BUSCAR

    void addVertex(T data) throws Exception;

    void deleteVertex(T value) throws Exception;

    boolean addEdge(T origin, T destination) throws Exception;

    boolean removeEdge(T origin, T destination);

    void dfs();

    void bfs(Vertex <T> vertex);

}
