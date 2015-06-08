import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marius on 21.05.2015.
 */
public class Graph {

    public static final String FILENAME = "frag.dat";
    public static List<Node> nodeList = new ArrayList<Node>();
    public static List<Edge> edgeList = new ArrayList<Edge>();

    //jedes Graph Objekt braucht seine eigene EdgeList & NodeList, siehe Edge Klasse
    //static context wird nicht mehr behalten werden können
    // assembler muss operationen übernehmen (?)

    public static void generateGraph() throws Exception {

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(FILENAME));
            String zeile = null;
            while ((zeile = inFile.readLine()) != null) {
                Node node = new Node(zeile);
                nodeList.add(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = 0; j < nodeList.size(); j++) {
                // compare list.get(i) and list.get(j)

                int gewicht = Sequence.overlap(nodeList.get(i).getSequence(), nodeList.get(j).getSequence());

                if (!nodeList.get(i).getSequence().equals(nodeList.get(j).getSequence())){

                    Edge edge = new Edge(nodeList.get(i), nodeList.get(j), gewicht);
                    edgeList.add(edge);
                }
            }
        }
        sortEdges();
    }

    public static void generateGraph(String namefile) throws Exception {
        List<Node> tmpnodeList= new ArrayList<Node>();

        try {
            System.out.println("generating another graph");
            BufferedReader inFile = new BufferedReader(new FileReader(namefile));
            String zeile = null;
            while ((zeile = inFile.readLine()) != null) {
                Node node = new Node(zeile);
                tmpnodeList.add(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < tmpnodeList.size(); i++) {
            for (int j = 0; j < tmpnodeList.size(); j++) {
                // compare list.get(i) and list.get(j)

                int gewicht = Sequence.overlap(tmpnodeList.get(i).getSequence(), tmpnodeList.get(j).getSequence());

                if (!tmpnodeList.get(i).getSequence().equals(tmpnodeList.get(j).getSequence())){

                    Edge edge = new Edge(tmpnodeList.get(i), tmpnodeList.get(j), gewicht);
                    edgeList.add(edge);
                }
            }
        }
        sortEdges();
    }

    public Graph (List<Node> nodeList, List<Edge> edgeList, String namefile) throws IOException {


        PrintWriter writer = new PrintWriter( new FileWriter( namefile ) );
        for (Node node : nodeList) {
            writer.println(node.getSequence());
        }

        writer.close();

    }


/*
        for(Edge edge : Graph.edgeList){
            System.out.println(edge);
        }

        sortEdges();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++HERE IS DA BREAK ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(Edge edge : Graph.edgeList){
            System.out.println(edge);
        }

*/



    public static void moldNodes(Node node1, Node node2) throws Exception{

        String newSeq = Sequence.mold(node1.getSequence(), node2.getSequence());
        nodeList.remove(node1);
        nodeList.remove(node2);
        Node newNode = new Node(newSeq);
        nodeList.add(newNode);
        Graph.refreshEdges();
    }

    public static List<Edge> refreshEdges() throws Exception{
        edgeList.clear();
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = 0; j < nodeList.size(); j++) {
                // compare list.get(i) and list.get(j)

                int gewicht = Sequence.overlap(nodeList.get(i).getSequence(), nodeList.get(j).getSequence());

                if (!nodeList.get(i).getSequence().equals(nodeList.get(j).getSequence())){

                    Edge edge = new Edge(nodeList.get(i), nodeList.get(j), gewicht);
                    edgeList.add(edge);
                }
            }
        }
        sortEdges();
        return edgeList;
    }

    public static List<Edge> sortEdges() throws Exception {

        Collections.sort(edgeList);
        return edgeList;
    }
}