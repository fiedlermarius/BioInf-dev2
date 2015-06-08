/**
 * Created by Marius on 21.05.2015.
 */
public class Node {

    public String sequence;

    public Node (String sequence){
    this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Node{" +
                "sequence='" + sequence + '\'' +
                '}';
    }
}
