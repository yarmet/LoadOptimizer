package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class LoadCalculator<T> {

    private boolean resultAchieved = false;
    private Node bestNode = null;
    private int load;
    private List<T> data;
    private Function<T, Integer> performanceExtractor;

    public LoadCalculator(int load, List<T> data, Function<T, Integer> performanceExtractor) {
        this.load = load;
        this.data = data;
        this.performanceExtractor = performanceExtractor;
    }

    public List<T> calculate() {
        process(null);
        return unpackBestNode(bestNode);
    }

    private void process(Node currentNode) {
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

    private List<T> unpackBestNode(Node node) {
        if (node == null) return Collections.emptyList();
        List<T> results = new ArrayList<>();

        do {
            results.add(data.get(node.getIdx()));
            node = node.getParent();
        } while (node != null);

        Collections.reverse(results);
        return results;
    }

}
