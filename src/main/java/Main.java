import calculator.LoadCalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//                                          usage

//      ----------------------  example 1  -----------------------------------------------------------------------------

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(5);
        integers.add(8);
        integers.add(10);
        integers.add(16);
        integers.add(11);
        integers.add(19);

        int requiredLoad = 18;
        LoadCalculator<Integer> integerLoadCalculator = new LoadCalculator<>(requiredLoad, integers, Integer::intValue);
        System.out.println(integerLoadCalculator.calculate());  // [8, 10]

        requiredLoad = 28;
        integerLoadCalculator = new LoadCalculator<>(requiredLoad, integers, Integer::intValue);
        System.out.println(integerLoadCalculator.calculate());  // [1, 8, 19]

//      ----------------------  example 2  -----------------------------------------------------------------------------

        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("w1", 10));
        workers.add(new Worker("w2", 1));
        workers.add(new Worker("w3", 20));
        workers.add(new Worker("w4", 12));
        workers.add(new Worker("w5", 4));
        workers.add(new Worker("w6", 6));
        workers.add(new Worker("w7", 18));

        requiredLoad = 18;
        LoadCalculator<Worker> workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate()); // [Worker(name=w4, performance=12), Worker(name=w6, performance=6)]

        requiredLoad = 0;
        workerLoadCalculator = new LoadCalculator<>(requiredLoad, workers, Worker::getPerformance);
        System.out.println(workerLoadCalculator.calculate()); // []
    }
}
