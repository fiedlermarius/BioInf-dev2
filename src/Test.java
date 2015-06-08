/**
 * Created by Marius on 21.05.2015.
 */
public class Test {

    public static void main(String args[]) throws Exception {

        Graph.generateGraph();

        String SubStr1 = new String("GTACTG");
        String SubStr2 = new String("ACT");
        String seq1 = new String("ACTGGTAC");
        String seq2 = new String("acgtgtgcatgactgactgactagc");
        String seq3 = new String("ALLEMEINEENTCHEN");
        String seq4 = new String("GGACTGTACGGTAGTAGTAGTAG");
        String seq5 = new String("GTAGTAGTAGTAGTACTGATC");
        String seq6 = new String ("AGCTGTGTCACACAACTTACTC");
        String seq7 = new String ("GTCACACAACTTACTCATCATCTAACGGT");
        Node node1 =  Graph.nodeList.get(15);
        Node node2 = Graph.nodeList.get(8);


        try {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("COMPARE TEST");
            System.out.println("should: true, true, true, false, false, false");
            System.out.println(Sequence.compare(SubStr1, SubStr2, 0));
            System.out.println(  Sequence.compare(SubStr1, SubStr2, 1));
            System.out.println(  Sequence.compare(SubStr1, SubStr2, 2));
            System.out.println(  Sequence.compare(SubStr1, SubStr2, 3));
            System.out.println(  Sequence.compare(SubStr1, SubStr2, 4));
            System.out.println(  Sequence.compare(SubStr1, SubStr2, 5));
            System.out.println("COMPARE TEST OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("VALIDITY TEST");
            System.out.println("should: true, false, false");
            System.out.println(Sequence.isValid(seq1));
            System.out.println(Sequence.isValid(seq2));
            System.out.println(Sequence.isValid(seq3));
            System.out.println("VALIDITY TEST OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("OVERLAP TEST");
            System.out.println("should: 13");
            System.out.println(Sequence.overlap(seq4, seq5));
            System.out.println("OVERLAP TEST OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("EDGE TEST (UNSORTED)");
            for(Edge edge : Graph.edgeList){
                System.out.println(edge);
            }
            System.out.println("EDGE TEST (UNSORTED) OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            Graph.sortEdges();
            System.out.println("EDGE TEST (SORTED)");
            for(Edge edge : Graph.edgeList){
                System.out.println(edge);
            }
            System.out.println("EDGE TEST (SORTED) OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("SEQUENCE MOLD TEST");
            System.out.println("should: AGCTGTGTCACACAACTTACTCATCATCTAACGGT");
            System.out.println("is:     "+Sequence.mold(seq6, seq7));
            System.out.println("SEQUENCE MOLD TEST OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("NODE MOLD TEST");
            System.out.println("Nodelist vorher:"+Graph.nodeList);
            //System.out.println("EdgeList vorher:"+Graph.edgeList);
            Graph.moldNodes(node1, node2);
            System.out.println("Nodelist nachher:"+Graph.nodeList);
            //System.out.println("Edgelist nachher:"+Graph.edgeList);
            System.out.println("NODE MOLD TEST OVER");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");



        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
