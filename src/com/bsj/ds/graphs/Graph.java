package com.bsj.ds.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

    private void removeConnection(String data, String destination,Boolean removalFlag){
        LinkedList<Edge> connectionList = edgeList.get(destination);
        if (connectionList == null) {
            return;
        }
        for(int i=0;i<connectionList.size()&&removalFlag==false;i++){
            if(data.equalsIgnoreCase(connectionList.get(i).endVertex))
            {
                removalFlag=true;
                connectionList.remove(i);
                removeConnection(destination,data,Boolean.FALSE);
            }
        }
        edgeList.put(destination, connectionList);
    }
    private void addConnection(String data, String destination) {
        addVertex(data);
        LinkedList<Edge> connectionList = edgeList.get(destination);
        if (connectionList == null) {
            connectionList = new LinkedList();
        }
        for(Edge connection:connectionList){
            if(data.equalsIgnoreCase(connection.endVertex)) return;
        }
        connectionList.add(0, new Edge(destination, data));
        edgeList.put(destination, connectionList);

        addConnection(destination, data);
    }

    private List<Edge> findConnections(String name){
        return edgeList.get(name);
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

        System.out.println("Connections of Ganesh"+graph.findConnections("Ganesh"));
        System.out.println("Graph : " + graph);
        graph.removeConnection("Divya", "Ganesh",false);

        /* graph.addConnection("Sakthi", "Ruby");*/
        System.out.println("Graph post removal : " + graph);
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
