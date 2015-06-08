import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marius on 27.05.2015.
 */
public class Graph2 {

    public  List<Node> nodeList = new ArrayList<Node>();
    public  List<Edge> edgeList = new ArrayList<Edge>();

    public Graph2 (String filename) throws Exception {


            try {
                BufferedReader inFile = new BufferedReader(new FileReader(filename));
                String zeile = null;
                while ((zeile = inFile.readLine()) != null) {
                    if (!Sequence.isValid(zeile)) {
                        System.out.println("Fehler in der Eingabedatei! Berechnung ungültig!");
                    }
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




    public Graph2(List < Node > nodeList, List < Edge > edgeList) {
        this.edgeList = edgeList;
        this.nodeList = nodeList;


    }




    public void moldNodes(Node node1, Node node2) throws Exception{

        String newSeq = Sequence.mold(node1.getSequence(), node2.getSequence());
        this.nodeList.remove(node1);
        this.nodeList.remove(node2);
        Node newNode = new Node(newSeq);
        this.nodeList.add(newNode);
        refreshEdges();
    }

    //HIER MUSS EIN GRAPH ANGEGEBEN WERDEN FÜR DEN DIE EDGES GEÄNDERT WERDEN SOLLEN

    public List<Edge> refreshEdges() throws Exception{

  //      this.edgeList.clear();
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



    public List<Edge> sortEdges() throws Exception {

        Collections.sort(edgeList);
        return edgeList;
    }
}
