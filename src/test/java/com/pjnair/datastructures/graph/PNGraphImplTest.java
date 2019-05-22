package com.pjnair.datastructures.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
    void removeVertex(){
        pnGraph.addVertex(1);
        pnGraph.addVertex(2);
        pnGraph.addVertex(3);
        pnGraph.removeVertex(1);
        pnGraph.printAdjacencyMatrix();
        pnGraph.removeVertex(3);
        pnGraph.printAdjacencyMatrix();
    }




}