package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Vertex <T> {

    private Vertex <T> vertexPredecesor;

    private List <Vertex<T>> adjacentVertices;
    private int distance;

    private int finalDistance;

    private Color color;

    private T data;


    public Vertex(T data) {
        this.adjacentVertices = new ArrayList<>();
        this.color = Color.WHITE;
        this.vertexPredecesor = null;
        this.distance = Integer.MAX_VALUE;
        this.data = data;
    }

    public void addAdjacentV(Vertex<T> adjacentV) {
        adjacentVertices.add(adjacentV);
    }


    public Vertex<T> getVertexPredecesor() {
        return vertexPredecesor;
    }

    public void setVertexPredecesor(Vertex<T> vertexPredecesor) {
        this.vertexPredecesor = vertexPredecesor;
    }

    public List<Vertex<T>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(List<Vertex<T>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void addAdjacent(Vertex<T> n) {
        adjacentVertices.add(n);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getFinalDistance() {
        return finalDistance;
    }

    public void setFinalDistance(int finalDistance) {
        this.finalDistance = finalDistance;
    }

    public void removeAdjacentVertex(Vertex<T> vertex) {

        adjacentVertices.remove(vertex);

    }
}
