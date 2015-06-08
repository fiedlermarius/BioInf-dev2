import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marius on 26.05.2015.
 */
public class Assembler {

    public static String FILENAME = "frag.dat";
    public static List<Graph2> graphList = new ArrayList<Graph2>();

    public void  start() throws Exception {


        graphList.add(new Graph2(FILENAME));
        Graph2 initialGraph = graphList.get(0);
// der kommt aus der while schleife nicht mehr raus

        while (initialGraph.edgeList.get(0).gewicht > 0) {

            //hier unten läuft irgendwas schief
            for (int i = 0; i < initialGraph.edgeList.size(); i++) {
                int maxGewicht = initialGraph.edgeList.get(0).gewicht;
                int count = 0;
                if (initialGraph.edgeList.get(i).gewicht == maxGewicht) {
                    count++;
                }
                if (count > 1) {
                    Graph2 newGraph = (new Graph2(initialGraph.nodeList, initialGraph.edgeList));
                    newGraph.edgeList.remove(0);
                    graphList.add(newGraph);
                    Edge heavyEdge = initialGraph.edgeList.get(0);
                    initialGraph.moldNodes(heavyEdge.getStartNode(), heavyEdge.getEndNode());
                } else {
                    Edge heavyEdge = initialGraph.edgeList.get(0);
                    initialGraph.moldNodes(heavyEdge.getStartNode(), heavyEdge.getEndNode());
                }
            }

        }

        System.out.println(graphList.size());
        System.out.println("Knoten uebrig:" + initialGraph.nodeList);
        if (initialGraph.nodeList.size() == 1) {
            System.out.println("yeah, we got ONE sequence: " + initialGraph.nodeList);
        }


        for (int j = 1; j < graphList.size() ; j++) {

            Graph2 currentGraph = graphList.get(j);
             while (currentGraph.edgeList.get(0).gewicht > 0) {
                for (int i = 0; i < currentGraph.edgeList.size(); i++) {
                    int maxGewicht = currentGraph.edgeList.get(0).gewicht;
                    int count = 0;
                    if (currentGraph.edgeList.get(i).gewicht == maxGewicht) {
                        count++;
                    }
                    if (count != 0) {
                        Graph2 newGraph = new Graph2(currentGraph.nodeList, currentGraph.edgeList);
                        newGraph.edgeList.remove(0);
                        graphList.add(newGraph);
                        Edge heavyEdge = currentGraph.edgeList.get(0);
                        currentGraph.moldNodes(heavyEdge.getStartNode(), heavyEdge.getEndNode());
                    } else {
                        Edge heavyEdge = currentGraph.edgeList.get(0);
                        currentGraph.moldNodes(heavyEdge.getStartNode(), heavyEdge.getEndNode());
                    }
                }
            }


            System.out.println(graphList.size());

            System.out.println("Knoten uebrig:" + currentGraph.nodeList);
            if (currentGraph.nodeList.size() == 1)
                System.out.println("yeah, we got ONE sequence: " + currentGraph.nodeList);

        }



        }



    public static void main(String args[]) throws Exception {


        Assembler one = new Assembler();
        one.start();

/*
        int filecount= 0;
        Graph.generateGraph();
        while(Graph.edgeList.get(0).gewicht>0) {

     // wieviele verzweigungen gibt es sonst noch
            int i;


            for ( i = 0 ; i < Graph.edgeList.size(); i++ ) {
                int maxGewicht = Graph.edgeList.get(0).gewicht;
                int count = 0;
                if (Graph.edgeList.get(i).gewicht == maxGewicht) {
                    count++;
                }
                if (count != 0 ) {
                    System.out.println(count);
                    String namefile = "frag" + filecount;
                    Graph anotherGraph = new Graph(Graph.nodeList, Graph.edgeList, namefile);
                    filecount++;
                    Graph.generateGraph(namefile);
                }

            }


            // falls es eine weitere mögliche abzweigung gibt, speichere den Graphen (in einer Datei) zwischen (Konstruktor für Graph benötigt: mit nodeList, edgeList und FILENAME)
            // schreibe am ende eines durchgangs die nodeList raus, wenn genau 1 element drin is, schreib "success" dabei
            Edge heavyEdge = Graph.edgeList.get(0);
            Graph.moldNodes(heavyEdge.getStartNode(), heavyEdge.getEndNode());

        }
        */

    }




}