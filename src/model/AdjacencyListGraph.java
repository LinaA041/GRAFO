package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListGraph<T> implements GraphInterface<T> {

    private List<Vertex<T>> vertices;

    private final boolean isDirected;

    private int time;

    public AdjacencyListGraph(boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isDirected = isDirected;
    }

    @Override
    public void addVertex(T value) throws Exception {

        if (searchV(value) == null) {

            Vertex<T> vertex = new Vertex<>(value);


            vertices.add(vertex);

        } else {

            throw new Exception("Value already exist ");

        }
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    @Override
    public void deleteVertex(T value) throws Exception {

        Vertex<T> vertex = searchV(value);

        if (vertex != null) {

            vertices.remove(vertex);

            for (Vertex<T> v : vertices) {

                List<Vertex<T>> adjacentVertices = v.getAdjacentVertices();

                adjacentVertices.removeIf(adjVertex -> adjVertex == value);
            }

        } else {

            throw new Exception("element not found");
        }

    }



    private Vertex<T> searchV(T value) {

        for (Vertex<T> searchedVertex : vertices) {

            if (searchedVertex.getData().equals(value)) {

                return searchedVertex;

            }

        }
        return null;
    }


    @Override
    public boolean addEdge(T origin, T destination) throws  Exception{

        Vertex <T> validateOrigin  = searchV(origin);

        Vertex <T> validateDestination = searchV(destination);

        if(validateOrigin == null || validateDestination == null){

            throw new Exception("One of the vertices does not exist, enter a valid vertex");

        }else{

            if (isDirected) {

                validateOrigin.addAdjacentV(validateDestination);

            } else {

                validateDestination.addAdjacentV(validateOrigin);

                validateOrigin.addAdjacentV(validateDestination);

            }

            return true;
        }
    }

   @Override
    public boolean removeEdge( T origin, T destination) {

       Vertex<T> validateOrigin = searchV(origin);

       Vertex<T> validateDestination = searchV(destination);

       if (validateOrigin == null || validateDestination == null) {

           return false;
       }

       if (validateOrigin.getAdjacentVertices().contains(validateDestination)) {

           validateOrigin.removeAdjacentVertex(validateDestination);

       }else{

           return false; // no son adyacentes

       }

       if (!isDirected && validateDestination.getAdjacentVertices().contains(validateOrigin)) {

           validateDestination.removeAdjacentVertex(validateOrigin);

           validateOrigin.removeAdjacentVertex(validateDestination);

       }

       return true;
    }

    @Override
    public void bfs(Vertex <T> s) {


        Queue<Vertex<T>> queue = new LinkedList<>();

        s.setColor(Color.GRAY);

        s.setDistance(0);

        s.setVertexPredecesor(null);

        queue.offer(s);

        while (!queue.isEmpty()) {

            Vertex <T> u = queue.poll();

            for (Vertex <T> v : u.getAdjacentVertices()) {

                if (v.getColor().equals(Color.WHITE)) {

                    v.setColor(Color.GRAY);

                    v.setDistance(u.getDistance() + 1);

                    v.setVertexPredecesor(u);

                    queue.offer(v);

                }
            }

            u.setColor(Color.BLACK);
        }



    }

    @Override
    public void dfs(){

        for (Vertex<T> u : vertices ) {

            u.setColor(Color.WHITE);

            u.setVertexPredecesor(null);

        }

        time = 0;

        for (Vertex <T> u : vertices) {

           if(u.getColor() == Color.WHITE) {

               dfsVisit(u);

           }
        }
    }

    public void dfsVisit(Vertex<T> u){

        time++;

        u.setDistance(time);

        u.setColor(Color.GRAY);

        for ( Vertex <T> v : u.getAdjacentVertices()) {

            if(v.getColor() == Color.WHITE){

              v.setVertexPredecesor(u);

              dfsVisit(v);

            }

        }
        u.setColor(Color.BLACK);

        time++;

        u.setFinalDistance(time);

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
