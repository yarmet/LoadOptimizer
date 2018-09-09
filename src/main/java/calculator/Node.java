package calculator;

import lombok.Getter;

@Getter
class Node {

    private Node parent;
    private int idx;
    private int nodeTotalCost;

    public Node(Node parent, int idx, int cost) {
        this.parent = parent;
        this.idx = idx;

        if (parent == null) {
            this.nodeTotalCost = cost;
        } else {
            this.nodeTotalCost = cost + parent.nodeTotalCost;
        }
    }

}
