package com.pjnair.datastructures.graph.undirectedgraph;

public interface PNGraph<T> {
    void addVertex(T vertex);
    void addEdge(T vertexA, T vertexB);
    void removeVertex(T vertex);
    void removeEdge(T vertexA, T vertexB);
}
