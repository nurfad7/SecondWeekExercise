package exercise;
import tools.ScannerCommandBuilder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Monday {
    private final Scanner scanner;

    public Monday(Scanner scanner) {
        this.scanner = scanner;
    }

    public void result() {
        //#1 Java Array Program For Array Rotation
        System.out.println("Let's input the array first.");
        ArrayList<Integer> arrayToRotate = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        int d = ScannerCommandBuilder
                .getIntegerFromUserInput(scanner,"Enter d: ");
        System.out.println(rotateArrayCustom(arrayToRotate, d).toString());
        //#2
    }

    private ArrayList<Integer> rotateArrayCustom(ArrayList<Integer> arrayToRotate, int d) {
        ArrayList<Integer> rotatedArray = new ArrayList<>();
        ArrayList<Integer> beforeLimitArray = new ArrayList<>();
        AtomicBoolean isStartToRotate = new AtomicBoolean(false);
        arrayToRotate.forEach(number -> {
            if (!isStartToRotate.get() && d == number) {
                beforeLimitArray.add(number);
                isStartToRotate.set(true);
            } else if(!isStartToRotate.get()) {
                beforeLimitArray.add(number);
            } else {
                rotatedArray.add(number);
            }
        });
        rotatedArray.addAll(beforeLimitArray);
        return rotatedArray;
    }
}
