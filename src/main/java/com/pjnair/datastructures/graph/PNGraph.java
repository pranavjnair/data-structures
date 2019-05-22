package com.pjnair.datastructures.graph;

public interface PNGraph {
    void addVertex(Integer vertex);
    void addEdge(Integer vertexA, Integer vertexB);
    void removeVertex(Integer vertex);
    void removeEdge(Integer vertexA, Integer vertexB);
}
