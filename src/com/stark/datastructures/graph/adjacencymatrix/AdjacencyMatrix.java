package com.stark.datastructures.graph.adjacencymatrix;

public class AdjacencyMatrix {
    public Graph createGraph(int numVertices){
        if(numVertices <=0 ){
            return null;
        }
        int i,j;
        Graph graph = new Graph();
        graph.V = numVertices;
        graph.E = 0;
        graph.adjMatrix = new int[numVertices][numVertices];
        for(i=0;i<numVertices;i++){
            for (j = 0 ; j<numVertices ; j++){
                graph.adjMatrix[i][j]=0;
            }
        }
        return graph;
    }

    public void displayGraph(Graph graph){
        int i,j,v;
        v = graph.V;
        System.out.println("Vertices:"+graph.V);
        System.out.println("Edeges:"+graph.E);

        for(i=0;i<v;i++){
            for(j=0;j<v;j++){
                System.out.print(graph.adjMatrix[i][j]+" ");
            }
            System.out.println();
        }

    }

    public void displayEdges(Graph graph){
        int i,j,v;
        v = graph.V;
        for (i=0; i<v; i++){
            for (j=0; j<v; j++){
                if(graph.adjMatrix[i][j]==1){
                    System.out.println(i+"-"+j);
                }
            }
        }
    }

    public void insertEdge(Graph graph,Edge edge){
        int x,y,v;
        v = graph.V;
        x=edge.source;
        y=edge.destination;
        if(x>=v || y>=v){
            System.out.println("ERROR while inserting. Source or/and destination cannot be greater than number of vertices");
            return;
        }
        if(graph.adjMatrix[x][y]==0){
            graph.adjMatrix[x][y] = 1;
            graph.adjMatrix[y][x] = 1;
            graph.E++;
        }
    }

    public void removeEdge(Graph graph, Edge edge){
        int x,y,v;
        v = graph.V;
        x = edge.source;
        y = edge.destination;
        if(x>=v || y>=v){
            System.out.println("ERROR while removing. Source or/and destination cannot be greater than number of vertices");
            return;
        }
        if(graph.adjMatrix[x][y]==1){
            graph.adjMatrix[x][y] = 0;
            graph.adjMatrix[y][x] = 0;
            graph.E--;
        }
    }

    public Edge newEdge(int source,int destination){
        Edge edge = new Edge();
        edge.destination = destination;
        edge.source = source;
        return edge;
    }
}
