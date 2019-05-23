package com.pjnair.datastructures.graph;

import com.pjnair.datastructures.graph.undirectedgraph.PNGraphImpl;
import org.junit.jupiter.api.Test;

class PNGraphImplTest {
    PNGraphImpl pnGraph = new PNGraphImpl();

    @Test
    void addVertex1(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void addVertex2(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.addVertex(4);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void addVertex3(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.addVertex(4);
        pnGraph.addVertex(5);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void addEdge1(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addEdge(1,2);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void addEdge2(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.addVertex(4);
        pnGraph.addEdge(1,2);
        pnGraph.addEdge(2,4);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void removeVertex1(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(1);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void removeVertex2(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(1);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(2);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void removeVertex3(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(0);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void removeVertex4(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(1);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(1);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void removeVertex5(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(0);
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeVertex(2);
        pnGraph.printAdjacencyMatrix();
    }

    @Test
    void removeEdge() {
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.printAdjacencyMatrix();
        pnGraph.addEdge(1, 2);
        pnGraph.addEdge(2, 3);
        System.out.println();
        pnGraph.printAdjacencyMatrix();
        System.out.println();
        pnGraph.removeEdge(1,2);
        pnGraph.printAdjacencyMatrix();
    }

}