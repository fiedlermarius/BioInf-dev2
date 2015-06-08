/**
 * Created by Marius on 21.05.2015.
 */
public class Edge implements Comparable<Edge> {

    public Node startNode;
    public Node endNode;
    public int gewicht;

    public Edge(Node startNode, Node endNode){
        this.startNode=startNode;
        this.endNode=endNode;
    }

    public Edge(Node startNode, Node endNode, int gewicht){
        this.startNode=startNode;
        this.endNode=endNode;
        this.gewicht=gewicht;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public int compareTo(Edge edge) {
        return edge.gewicht - this.gewicht ;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startNode=" + startNode +
                ", endNode=" + endNode +
                ", gewicht=" + gewicht +
                '}' + "\n";
    }
}
