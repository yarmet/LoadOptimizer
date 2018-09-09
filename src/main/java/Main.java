import calculator.LoadCalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // usage

        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("w1", 10));
        workers.add(new Worker("w2", 1));
        workers.add(new Worker("w3", 20));
        workers.add(new Worker("w4", 12));
        workers.add(new Worker("w5", 4));
        workers.add(new Worker("w6", 6));
        workers.add(new Worker("w7", 18));

        int requiredLoad = 18;
        LoadCalculator<Worker> workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate());
//      [Worker(name=w4, performance=12), Worker(name=w6, performance=6)]

        requiredLoad = 8;
        workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate());
//      [Worker(name=w2, performance=1), Worker(name=w6, performance=6)]

        requiredLoad = 38;
        workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate());
//      [Worker(name=w1, performance=10), Worker(name=w5, performance=4), Worker(name=w6, performance=6), Worker(name=w7, performance=18)]

        requiredLoad = 1;
        workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate());
//      [Worker(name=w2, performance=1)]

        requiredLoad = 0;
        workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate());
//      []
    }
}
