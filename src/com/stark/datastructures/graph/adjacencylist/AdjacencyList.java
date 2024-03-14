package com.stark.datastructures.graph.adjacencylist;


import com.stark.datastructures.linkedlist.ListNode;

public class AdjacencyList {
    public GraphList createGraph(int numVertices){
        if(numVertices <=0 ){
            return null;
        }
        int i,j;
        GraphList graph = new GraphList();
        graph.V = numVertices;
        graph.E = 0;
        for(i=0;i<numVertices;i++){
            graph.adjList[i] = new ListNode();
            graph.adjList[i].val = i;
            graph.adjList[i].next = null;
        }
        return graph;
    }

    public void insertEdge(GraphList graph, EdgeList edge){
        int n, to, from;
        n = graph.V;
        from = edge.source;
        to = edge.destination;
        if(0 > from || from > n || 0 > to || to > n){
            System.out.println("ERROR while inserting. Source or/and destination cannot be greater than number of vertices");
            return;
        }
        ListNode prev=null;
        ListNode ptr = graph.adjList[from];
        while(ptr != null){
            if(ptr.val == to){
                return;
            }else{
                prev = ptr;
                ptr = ptr.next;
            }
        }
        ListNode node = new ListNode();
        node.val = to;
        node.next = null;
        if(prev == null){
            graph.adjList[from] = node;
        }else{
            prev.next = node;
        }
        graph.E++;
    }

    public void removeEdge(GraphList graph, EdgeList edge){
        int n, to, from;
        n = graph.V;
        from = edge.source;
        to = edge.destination;
        if(0 > from || from > n || 0 > to || to > n){
            System.out.println("ERROR while inserting. Source or/and destination cannot be greater than number of vertices");
            return;
        }
        ListNode prev=null;
        ListNode ptr = graph.adjList[from];
        while(ptr != null){
            if(ptr.val == to){
                if(prev == null){
                    graph.adjList[from]=ptr.next;
                    graph.E--;
                    return;
                }else{
                    prev.next = ptr.next;
                    graph.E--;
                    return;
                }
            }else{
                prev = ptr;
                ptr = ptr.next;
            }
        }
    }

    public  void displayGraph(GraphList graph){
        ListNode ptr;
        int i;
        for(i=0; i<graph.V ; i++){
            ptr = graph.adjList[i];
            System.out.print("node "+i+" neighbours: ");
            while(ptr != null){
                System.out.print(ptr.val+" ");
            }
            System.out.println();
        }
    }

}
