package main;

import calculator.SequenceSearcher;
import calculator.SequenceFastSearcher;
import calculator.ShortSequenceSearcher;

public class Main {

    public static void main(String[] args) {
        InputParams inputParams = Parser.parse();
        SequenceSearcher<Integer> sequenceSearcher;

        if (inputParams.isNeedShortSequence()) {
            sequenceSearcher = new ShortSequenceSearcher<>(inputParams.getTotal(), inputParams.getValues(), Integer::intValue);
        } else {
            sequenceSearcher = new SequenceFastSearcher<>(inputParams.getTotal(), inputParams.getValues(), Integer::intValue);
        }
        System.out.println("Результат : " + sequenceSearcher.calculate());


//        int total = 110;
//        List<Worker> workerList = new ArrayList<>();
//        workerList.add(new Worker("safd2", 13));
//        workerList.add(new Worker("safd3", 133));
//        workerList.add(new Worker("safd4", 23));
//        workerList.add(new Worker("safd5", 63));
//
//        SequenceSearcher<Worker> calculator1 = new ShortSequenceSearcher<>(total, workerList, Worker::getPerformance);
//        System.out.println(calculator1.calculate());
    }
}
