package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public abstract class Calculator<T> {

    protected boolean resultAchieved = false;
    protected Node bestNode = null;
    protected int load;
    protected List<T> data;
    protected Function<T, Integer> performanceExtractor;


    public Calculator(int load, List<T> data, Function<T, Integer> performanceExtractor) {
        this.load = load;
        this.data = data;
        this.performanceExtractor = performanceExtractor;
    }

    public List<T> calculate() {
        process(null);
        return unpackBestNode(bestNode);
    }

    abstract protected void process(Node currentNode);


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
