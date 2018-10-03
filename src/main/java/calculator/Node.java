package calculator;

import lombok.Getter;

@Getter
public class Node {

    private Node parent;
    private int idx;
    private int nodeTotalCost;
    private int nodeLength;

    public Node(Node parent, int idx, int cost) {
        this.parent = parent;
        this.idx = idx;

        if (parent == null) {
            this.nodeTotalCost = cost;
            this.nodeLength = 1;
        } else {
            this.nodeTotalCost = cost + parent.nodeTotalCost;
            this.nodeLength = parent.nodeLength + 1;
        }
    }

}
