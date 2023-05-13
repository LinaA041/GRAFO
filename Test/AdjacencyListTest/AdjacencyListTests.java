package AdjacencyListTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

import java.util.Arrays;
import java.util.List;

public class AdjacencyListTests {

    @Test
    void testAddOneVertex() {

        AdjacencyListGraph<Integer> prueba = new AdjacencyListGraph<>(false);

        try{

            prueba.addVertex(1);

            List<Vertex<Integer>> verticesList = prueba.getVertices();

            assertEquals(1, verticesList.size());

            assertEquals(1, verticesList.get(0).getData());

        } catch ( Exception e){

            assertEquals(Exception.class, e.getClass());
        }

    }



    @Test
    public void testAddVertex() {

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);

        try {

            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(1);

            graph.addVertex(3);

            graph.addVertex(4);

            List<Vertex<Integer>> verticesList = graph.getVertices();

            assertEquals(4, verticesList.size());

            assertTrue(true);

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void thirdTestToAddVertex(){

        AdjacencyListGraph<Object> graph = new AdjacencyListGraph<>(true);


        try{

            graph.addVertex("Lina Andrade");

            graph.addVertex(42);

            graph.addVertex(true);

            List<Vertex<Object>> verticesList = graph.getVertices();

            assertEquals(3, verticesList.size());

            assertEquals("Lina Andrade", verticesList.get(0).getData());

            assertEquals(42, verticesList.get(1).getData());

            assertEquals(true, verticesList.get(2).getData());

        }catch(Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    //undirected graph
    @Test
    void testAddEdge(){

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);

        try{

            graph.addVertex(1);

            graph.addVertex(2);

            boolean result = graph.addEdge(1, 2);

            List<Vertex<Integer>> vertices = graph.getVertices();

            List<Vertex<Integer>> adjacentVerticesList = vertices.get(0).getAdjacentVertices();


            assertEquals(2, vertices.size());

            assertEquals(1, adjacentVerticesList.size());

            assertEquals(2, adjacentVerticesList.get(0).getData());



            adjacentVerticesList = vertices.get(1).getAdjacentVertices();

            assertEquals(1, adjacentVerticesList.size());

            assertEquals(1, adjacentVerticesList.get(0).getData());

            assertTrue(result);

        }catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void testAddEdgeWithoutAVertex(){

        try{

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);

            graph.addVertex(3);

            boolean result = graph.addEdge(1, 2);

            assertFalse(result);

        }catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    //directed graph
    @Test
    void testAddEdge3(){

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

        try{

            graph.addVertex(3);

            graph.addVertex(4);

            boolean result = graph.addEdge(3, 4);

            List<Vertex<Integer>> vertices = graph.getVertices();

            List<Vertex<Integer>> adjacentVerticesList = vertices.get(0).getAdjacentVertices();

            assertEquals(1, adjacentVerticesList.size());

            assertEquals(4, adjacentVerticesList.get(0).getData());

            assertTrue(result);

        }catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    //non-existent vertex
    @Test
    void deleteVertexTest(){

        try{

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

            graph.addVertex(1);

            graph.addVertex(2);

            List<Vertex<Integer>> vertices = graph.getVertices();

            assertEquals(2, vertices.size());


        } catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void testDeleteVertex(){

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(3);

            graph.addVertex(3);

            graph.deleteVertex(2);

            List<Vertex<Integer>> vertices = graph.getVertices();

            List<Vertex<Integer>> adjacentVerticesList = vertices.get(0).getAdjacentVertices();

            assertEquals(2, vertices.size());

            assertEquals(1, vertices.get(0).getData());

            assertEquals(3, vertices.get(1).getData());

            assertEquals(0, adjacentVerticesList.size());


        }catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void testRemoveVertex(){

        try{

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

            graph.addVertex(1);

            graph.addVertex(2);

            graph.addEdge(1, 2);

            graph.deleteVertex(1);

            List<Vertex<Integer>> vertices = graph.getVertices();

            assertEquals(1, vertices.size());

            assertEquals(2, vertices.get(0).getData());

            assertEquals(0, vertices.get(0).getAdjacentVertices().size());


        }catch(Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void removeEdgeTest(){

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);


            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(3);


            graph.addEdge(1, 2);
            graph.addEdge(2, 3);


            boolean result = graph.removeEdge(1, 3);


            assertFalse(result);


            Vertex<Integer> vertex1 = graph.getVertices().get(0);
            Vertex<Integer> vertex2 = graph.getVertices().get(1);
            Vertex<Integer> vertex3 = graph.getVertices().get(2);

            List<Vertex<Integer>> adjacencyList1 = vertex1.getAdjacentVertices();
            List<Vertex<Integer>> adjacencyList2 = vertex2.getAdjacentVertices();
            List<Vertex<Integer>> adjacencyList3 = vertex3.getAdjacentVertices();

            assertEquals(1, adjacencyList1.size());
            assertEquals(2, adjacencyList2.size());
            assertEquals(0, adjacencyList3.size());

        }catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void removeEdgeTest2(){}

    @Test
    void removeEdgeTest3(){}
    @Test


}

