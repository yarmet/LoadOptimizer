package calculator;

import java.util.List;
import java.util.function.Function;

public class ShortSequenceFinder<T> extends Calculator<T> {

    public ShortSequenceFinder(int load, List<T> data, Function<T, Integer> performanceExtractor) {
        super(load, data, performanceExtractor);
    }

    @Override
    protected void process(Node currentNode) {
        if (currentNode != null) {
            if (currentNode.getNodeTotalCost() > load)
                return; //если текущя нода содержит, большее значение, чем нам нужно, то дальше нет смысла продолжать искать вглубь.

            if (bestNode == null ||
                    bestNode.getNodeTotalCost() < currentNode.getNodeTotalCost() ||
                    (bestNode.getNodeTotalCost() == currentNode.getNodeTotalCost()
                            && bestNode.getNodeLength() > currentNode.getNodeLength())
            )
                bestNode = currentNode; // если текущая нода лучше прежней, то запоминаем ее.
        }

        int startPos = currentNode == null ? 0 : currentNode.getIdx() + 1;
        for (int i = startPos; i < data.size(); i++) {
            Node node1 = new Node(currentNode, i, performanceExtractor.apply(data.get(i)));
            process(node1);
        }

    }


}
