package com.bsj.ds.graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    //int numberOfVertices;
    //String data;
    HashMap<String, LinkedList<Edge>> edgeList;

    public Graph() {
        edgeList = new HashMap<>();
    }

    /**
     * Method to create new member in FB
     *
     * @param data
     */
    private void addVertex(String data) {
        LinkedList edge = edgeList.get(data);
        if (edge == null) {
            LinkedList newEdge = new LinkedList();
            edgeList.put(data, newEdge);
        }
    }

    private void addConnection(String data, String destination) {
        addVertex(data);
        LinkedList<Edge> connectionList = edgeList.get(destination);
        if (connectionList == null) {
            connectionList = new LinkedList();
        }
        for(Edge connection:connectionList){
            if(data.equalsIgnoreCase(connection.endVertex))
            {
                System.out.println("Names are equal");
                return;
            }
        }
        connectionList.add(0, new Edge(destination, data));
        edgeList.put(destination, connectionList);

        addConnection(destination, data);
    }

    @Override
    public String toString() {
        String result = "";
        System.out.println("Vertex list : " + edgeList.keySet());
        for (String vertex : edgeList.keySet()) {
            LinkedList<Edge> edges = edgeList.get(vertex);
            result += vertex + " --> ";
            for (Edge edge : edges) {
                result += edge;
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.addVertex("Ruby");
        graph.addVertex("Ganesh");
        graph.addVertex("Sakthi");

       /* graph.addConnection("Banu", "Ruby");
        graph.addConnection("Divya", "Ruby");*/
        graph.addConnection("Sakthi", "Ganesh");
        graph.addConnection("Sakthi", "Ganesh");
        graph.addConnection("Ganesh", "Ruby");
        graph.addConnection("Ganesh", "Divya");
        graph.addConnection("Divya", "Ruby");

        /* graph.addConnection("Sakthi", "Ruby");*/
        System.out.println("Graph : " + graph);
    }
}

class Edge {
    //String startVertex;
    String endVertex;
    int weight;

    public Edge(String startVertex, String endVertex) {
        // this.startVertex=startVertex;
        this.endVertex = endVertex;
    }

    @Override
    public String toString() {
        return "[" + endVertex + " , " + weight + "]" + ",";
    }
}
