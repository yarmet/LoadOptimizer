package calculator;

import java.util.List;
import java.util.function.Function;

public class SequenceFastSearcher<T> extends Calculator<T> {

    public SequenceFastSearcher(int load, List data, Function<T, Integer> performanceExtractor) {
        super(load, data, performanceExtractor);
    }

    protected void process(Node currentNode) {
        if (currentNode != null) {
            if (currentNode.getNodeTotalCost() > load)
                return; //если текущя нода содержит, большее значение, чем нам нужно, то дальше нет смысла продолжать искать вглубь.
            if (bestNode == null || bestNode.getNodeTotalCost() < currentNode.getNodeTotalCost())
                bestNode = currentNode; // если текущая нода лучше прежней, то запоминаем ее.
            if (currentNode.getNodeTotalCost() == load)
                resultAchieved = true; // результат достигнут
        }
        int startPos = currentNode == null ? 0 : currentNode.getIdx() + 1;
        for (int i = startPos; i < data.size(); i++) {
            if (resultAchieved) return;
            Node node1 = new Node(currentNode, i, performanceExtractor.apply(data.get(i)));
            process(node1);
        }
    }
}
