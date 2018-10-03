package tst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public static InputParams parse() {
        Scanner scanner = new Scanner(System.in);
        int target = getTargetValue(scanner);
        List<Integer> integers = getSequence(scanner);
        boolean needShortSequence = needShortSequence(scanner);
        return new InputParams(target, integers, needShortSequence);
    }

    private static boolean needShortSequence(Scanner scanner) {
        System.out.println("искать короткую последовательность? (y/n)");

        while (true) {
            String total = scanner.nextLine().trim();
            if (total.equals("y")) {
                return true;
            } else if (total.equals("n")) {
                return false;
            } else {
                System.out.println("неправильно введено значение, введите (y/n)");
            }
        }
    }

    private static int getTargetValue(Scanner scanner) {
        System.out.println("Введи число, до которого нужно добрать");
        int result = 0;
        boolean askAgain = true;
        do {
            String total = scanner.nextLine();
            try {
                result = Integer.parseInt(total);
                askAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, неправильно введено число, нужно ввести целое число, попробуй еще раз");
            }
        } while (askAgain);

        return result;
    }


    private static List<Integer> getSequence(Scanner scanner) {
        System.out.println("Введи числа через пробел, из которых нужно добрать число");
        List<Integer> integerList = null;
        boolean askAgain = true;
        do {
            String[] total = scanner.nextLine().split(" ");
            try {
                integerList = new ArrayList<>();
                for (String str : total) {
                    integerList.add(Integer.parseInt(str));
                }
                askAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, неправильно введены числа, нужно ввести целые числа через пробел, попробуй еще раз");
            }
        } while (askAgain);
        return integerList;
    }

}
