package com.pjnair.datastructures.graph;

import com.pjnair.datastructures.arraylist.PNArrayListImpl;

public class PNGraphImpl implements PNGraph {

    private int totalVertices = 0;
    private final int START_SIZE = 5;
    private Integer[][] adjacencyMatrix = new Integer[START_SIZE][START_SIZE]; // remember to change to private
    private Integer[] nodesInAdjacencyMatrix = new Integer[START_SIZE];

    public PNGraphImpl() {
        for (int i = 0; i < this.nodesInAdjacencyMatrix.length; i++){
            this.nodesInAdjacencyMatrix[i] = null;
        }
        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            for (int j = 0; j < this.adjacencyMatrix[0].length; j++) {
                this.adjacencyMatrix[i][j] = null;
            }
        }
    }

    @Override
    public void addVertex(Integer vertex) {
        this.totalVertices++;

        addNewNodeToList(vertex);

        if (this.totalVertices == this.adjacencyMatrix.length) {
            Integer[][] newAdjacencyMatrix = new Integer[this.adjacencyMatrix.length * 2][this.adjacencyMatrix.length * 2];
            for (int i = 0; i < this.adjacencyMatrix.length; i++) {
                for (int j = 0; j < this.adjacencyMatrix[0].length; j++) {
                    if (!(this.adjacencyMatrix[i][j] == null)) {
                        newAdjacencyMatrix[i][j] = this.adjacencyMatrix[i][j];
                    } else {
                        newAdjacencyMatrix[i][j] = null;
                    }
                }
            }
            this.adjacencyMatrix = newAdjacencyMatrix;
        }

        this.adjacencyMatrix[this.totalVertices - 1][this.totalVertices - 1] = 0;
    }

    private void addNewNodeToList(Integer vertex) {
        for (int i = 0; i < this.nodesInAdjacencyMatrix.length; i++) {
            if (this.nodesInAdjacencyMatrix[i] == null) {
                this.nodesInAdjacencyMatrix[i] = vertex;
                break;
            }
        }
        if (this.totalVertices == this.nodesInAdjacencyMatrix.length) {
            Integer[] newNodesInAdjacencyMatrix = new Integer[this.nodesInAdjacencyMatrix.length * 2];
            for (int i = 0; i < this.nodesInAdjacencyMatrix.length; i++) {
                newNodesInAdjacencyMatrix[i] = this.nodesInAdjacencyMatrix[i];
            }
            this.nodesInAdjacencyMatrix = newNodesInAdjacencyMatrix;
        }
    }

    @Override
    public void addEdge(Integer vertexA, Integer vertexB) {
        int vertexAIndex = getIndexOfInteger(vertexA);
        int vertexBIndex = getIndexOfInteger(vertexB);
        this.adjacencyMatrix[vertexAIndex][vertexBIndex] = 1;
        this.adjacencyMatrix[vertexBIndex][vertexAIndex] = 1;
    }

    private int getIndexOfInteger(Integer vertex){
        for (int i = 0; i < this.nodesInAdjacencyMatrix.length; i++){
            if (this.nodesInAdjacencyMatrix[i].equals(vertex)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeVertex(Integer vertex) {
        int vertexToRemoveIndex = getIndexOfInteger(vertex);
        removeIndexOfInteger(vertexToRemoveIndex);
        Integer[][] newAdjacencyMatrix = new Integer[this.adjacencyMatrix.length][this.adjacencyMatrix.length];
        // System.out.println("vertexToRemove: "+vertexToRemoveIndex);
        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            if (!(i == vertexToRemoveIndex)) {
                for (int j = 0; j < this.adjacencyMatrix[0].length; j++) {
                    if (!(j == vertexToRemoveIndex) && !(this.adjacencyMatrix[i][j] == null)) {
                        newAdjacencyMatrix[i][j] = this.adjacencyMatrix[i][j];
                    }
                }
            }
        }
        this.adjacencyMatrix = newAdjacencyMatrix;
    }

    private void removeIndexOfInteger(int indexToRemove){
        if (indexToRemove < 0){
            return;
        }
        this.nodesInAdjacencyMatrix[indexToRemove] = null;
    }

    @Override
    public void removeEdge(Integer vertexA, Integer vertexB) {

    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            for (int j = 0; j < this.adjacencyMatrix[0].length; j++) {
                System.out.print(this.adjacencyMatrix[i][j] + "     ");
            }
            System.out.println();
        }
    }
}
