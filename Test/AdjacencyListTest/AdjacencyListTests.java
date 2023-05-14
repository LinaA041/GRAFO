package AdjacencyListTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import model.*;

import java.util.List;

public class AdjacencyListTests {

    @Test
    void testAddOneVertex() {

        AdjacencyListGraph<Integer> prueba = new AdjacencyListGraph<>(false);

        try {

            prueba.addVertex(1);

            List<Vertex<Integer>> verticesList = prueba.getVertices();

            assertEquals(1, verticesList.size());

            assertEquals(1, verticesList.get(0).getData());

        } catch (Exception e) {

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
    void thirdTestToAddVertex() {

        AdjacencyListGraph<Object> graph = new AdjacencyListGraph<>(true);


        try {

            graph.addVertex("Lina Andrade");

            graph.addVertex(42);

            graph.addVertex(true);

            List<Vertex<Object>> verticesList = graph.getVertices();

            assertEquals(3, verticesList.size());

            assertEquals("Lina Andrade", verticesList.get(0).getData());

            assertEquals(42, verticesList.get(1).getData());

            assertEquals(true, verticesList.get(2).getData());

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    //undirected graph
    @Test
    void testAddEdge() {

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);

        try {

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

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void testAddEdgeWithoutAVertex() {

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);

            graph.addVertex(3);

            boolean result = graph.addEdge(1, 2);

            assertFalse(result);

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    //directed graph
    @Test
    void testAddEdge3() {

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

        try {

            graph.addVertex(3);

            graph.addVertex(4);

            boolean result = graph.addEdge(3, 4);

            List<Vertex<Integer>> vertices = graph.getVertices();

            List<Vertex<Integer>> adjacentVerticesList = vertices.get(0).getAdjacentVertices();

            assertEquals(1, adjacentVerticesList.size());

            assertEquals(4, adjacentVerticesList.get(0).getData());

            assertTrue(result);

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    //non-existent vertex
    @Test
    void deleteVertexTest() {

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

            graph.addVertex(1);

            graph.addVertex(2);

            List<Vertex<Integer>> vertices = graph.getVertices();

            assertEquals(2, vertices.size());


        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void testDeleteVertex() {

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


        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void testRemoveVertex() {

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

            graph.addVertex(1);

            graph.addVertex(2);

            graph.addEdge(1, 2);

            graph.deleteVertex(1);

            List<Vertex<Integer>> vertices = graph.getVertices();

            assertEquals(1, vertices.size());

            assertEquals(2, vertices.get(0).getData());

            assertEquals(0, vertices.get(0).getAdjacentVertices().size());


        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void removeEdgeTest() {

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


            List<Vertex<Integer>> adjacentVerticesList1 = vertex1.getAdjacentVertices();

            List<Vertex<Integer>> adjacentVerticesList2 = vertex2.getAdjacentVertices();

            List<Vertex<Integer>> adjacentVerticesList3 = vertex3.getAdjacentVertices();


            assertEquals(1, adjacentVerticesList1.size());

            assertEquals(2, adjacentVerticesList2.size());

            assertEquals(1, adjacentVerticesList3.size());

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void removeEdgeTest2() {

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);


            graph.addVertex(4);

            graph.addVertex(5);

            graph.addVertex(6);


            graph.addEdge(4, 5);

            graph.addEdge(4, 6);


            boolean result = graph.removeEdge(4, 6);


            assertTrue(result);

            Vertex<Integer> vertexOfOrigin = graph.getVertices().get(0);

            Vertex<Integer> vertexOfDestination = graph.getVertices().get(2);


            List<Vertex<Integer>> adjacentVerticesList2 = vertexOfDestination.getAdjacentVertices();


            assertFalse(vertexOfOrigin.getAdjacentVertices().isEmpty()); //aunque se elimino la arista entre (4,6)
            // también existe una arista entre (4,5) por lo que el vertice "4"  aun tiene un vertice adyacente, es decir,
            // no esta vacio

            assertTrue(adjacentVerticesList2.isEmpty()); // en este caso, no habia ninguna otra arista que relacionara
            //al vertice seis.


        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void removeEdgeTest3() {

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);


            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(3);


            graph.addEdge(1, 2);

            graph.addEdge(2, 3);


            boolean result = graph.removeEdge(2, 3);


            assertTrue(result);

            Vertex<Integer> vertex = graph.getVertices().get(1);

            List<Vertex<Integer>> adjacency = vertex.getAdjacentVertices();

            assertTrue(adjacency.isEmpty());

        } catch (Exception e) {

            assertEquals(Exception.class, e.getClass());

        }
    }


    @Test
    void dfsColorTest(){

        try{

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);


            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(3);



            graph.addEdge(1, 2);

            graph.addEdge(1, 3);


            graph.dfs();

            Vertex<Integer> vertex1 = graph.getVertices().get(0);

            Vertex<Integer> vertex2 = graph.getVertices().get(1);

            Vertex<Integer> vertex3 = graph.getVertices().get(2);


            assertEquals(Color.BLACK, vertex1.getColor());

            assertEquals(Color.BLACK, vertex2.getColor());

            assertEquals(Color.BLACK, vertex3.getColor());

        }catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void dfsTest(){

        try {

            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);


            graph.addVertex(44);

            graph.addVertex(988);

            graph.addVertex(33);


            graph.addEdge(44, 988);

            graph.addEdge(44, 33);


            graph.dfs();

            Vertex<Integer> vertex1 = graph.getVertices().get(0);

            Vertex<Integer> vertex2 = graph.getVertices().get(1);

            Vertex<Integer> vertex3 = graph.getVertices().get(2);


            assertNull(vertex1.getVertexPredecesor());

            assertEquals(vertex1, vertex2.getVertexPredecesor());

            assertEquals(vertex1, vertex3.getVertexPredecesor());


        } catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void dfsTest3(){

        try{

            AdjacencyListGraph <Integer> prueba = new AdjacencyListGraph<>(true);


            prueba.addVertex(1);

            prueba.addVertex(2);


            prueba.addEdge(1,2);


            prueba.dfs();

            Vertex<Integer> vertex1 = prueba.getVertices().get(0);

            Vertex<Integer> vertex2 = prueba.getVertices().get(1);


            assertEquals(1, vertex1.getDistance());

            assertEquals(2, vertex2.getDistance());

        }catch (Exception e ){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void bfsSizeTest() {

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

        try {


            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(3);

            graph.addEdge(1, 2);

            graph.addEdge(1, 3);

            graph.addEdge(2, 3);

            Vertex<Integer> vertex1 = graph.getVertices().get(0);

            graph.bfs(vertex1);

            assertEquals(3, graph.getVertices().size());

        } catch (Exception e ){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void bfsPredecessorTest() {

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true);

        try {

            graph.addVertex(1);

            graph.addVertex(2);

            graph.addVertex(3);


            graph.addEdge(1, 2);

            graph.addEdge(1, 3);

            graph.addEdge(2, 3);


            Vertex<Integer> vertex1 = graph.getVertices().get(0);


            graph.bfs(vertex1);


            Vertex<Integer> vertex2 = graph.getVertices().get(1);


            Vertex<Integer> vertex3 = graph.getVertices().get(2);


            assertEquals(vertex1, vertex2.getVertexPredecesor());


            assertEquals(vertex1, vertex3.getVertexPredecesor());


        } catch (Exception e ){

            assertEquals(Exception.class, e.getClass());

        }
    }

    @Test
    void bfsDistanceTest() {

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false);

        try {

            graph.addVertex(4);

            graph.addVertex(5);

            graph.addVertex(6);


            graph.addEdge(4, 5);

            graph.addEdge(6, 5);


            Vertex<Integer> vertex1 = graph.getVertices().get(0);

            graph.bfs(vertex1);


            Vertex<Integer> vertex2 = graph.getVertices().get(1);

            Vertex<Integer> vertex3 = graph.getVertices().get(2);


            assertEquals(0, vertex1.getDistance());

            assertEquals(1, vertex2.getDistance());

            assertEquals(2, vertex3.getDistance());


        } catch (Exception e){

            assertEquals(Exception.class, e.getClass());

        }
    }
}



