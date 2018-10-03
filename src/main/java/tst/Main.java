package tst;

import calculator.Calculator;
import calculator.SequenceFastSearcher;
import calculator.ShortSequenceFinder;

public class Main {

    public static void main(String[] args) {
        InputParams inputParams = Parser.parse();
        Calculator<Integer> calculator;

        if (inputParams.isNeedShortSequence()) {
            calculator = new ShortSequenceFinder<>(inputParams.getTotal(), inputParams.getValues(), Integer::intValue);
        } else {
            calculator = new SequenceFastSearcher<>(inputParams.getTotal(), inputParams.getValues(), Integer::intValue);
        }
        System.out.println("Результат : " + calculator.calculate());


//        int total = 110;
//        List<Worker> workerList = new ArrayList<>();
//        workerList.add(new Worker("safd2", 13));
//        workerList.add(new Worker("safd3", 133));
//        workerList.add(new Worker("safd4", 23));
//        workerList.add(new Worker("safd5", 63));
//
//        Calculator<Worker> calculator1 = new ShortSequenceFinder<>(total, workerList, Worker::getPerformance);
//        System.out.println(calculator1.calculate());
    }
}
