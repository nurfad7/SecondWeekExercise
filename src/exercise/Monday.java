package exercise;

import tools.ScannerCommandBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Monday {
    private final Scanner scanner;

    public Monday(Scanner scanner) {
        this.scanner = scanner;
    }

    public void result() {
        //#1 Java Array Program For Array Rotation
        System.out.println("Let's input the array to rotate first.");
        ArrayList<Integer> arrayToRotate = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        int d = ScannerCommandBuilder
                .getIntegerFromUserInput(scanner,"Enter d: ");
        System.out.println(rotateArrayCustom(arrayToRotate, d).toString());
        //#2 Check if Array Contain Duplicates
        System.out.println("Let's input the array to check of duplication first.");
        ArrayList<Integer> arrayToCheckDuplicate = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        System.out.println(arrayToCheckDuplicate.toString());
        System.out.println(isDuplicated(arrayToCheckDuplicate));
        //#3 (1) Remove Duplicate Elements From an Array
        System.out.println("Let's input the array to filter duplicate number first.");
        ArrayList<Integer> arrayToFilterDuplicate = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        System.out.println("Before: " + arrayToFilterDuplicate.toString());
        System.out.println("After: " + removeDuplicate(arrayToFilterDuplicate));
        //#3 (2) sort array in increasing & decreasing order
        System.out.println("Let's input the array to reorder first.");
        ArrayList<Integer> arrayToReorder = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        String orderType;
        scanner.nextLine();
        do {
            orderType = ScannerCommandBuilder
                    .getStringFromUserInput(scanner,"Type order (asc/desc): ");
        } while (!orderType.equalsIgnoreCase("asc") && !orderType.equalsIgnoreCase("desc"));
        System.out.println(reorderArray(arrayToReorder, orderType));
        //#4 Remove All Occurrences of an Element in an Array
        System.out.println("Let's input the array to filter first.");
        ArrayList<Integer> arrayToFilter = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        int valueToRemove = ScannerCommandBuilder
                .getIntegerFromUserInput(scanner,"Enter key: ");
        System.out.println("Before: " + arrayToFilter.toString());
        System.out.println("After: " + filterArrayByNumber(arrayToFilter, valueToRemove));
        //#5 Reverse a String Without Using Built-in Methods
        scanner.nextLine();
        String stringToReverse = ScannerCommandBuilder
                .getStringFromUserInput(scanner,"Type text to reverse: ");
        reverseString(stringToReverse);
        //#6 Find all Duplicates on Array
        System.out.println("Let's input the array to store the duplicate value.");
        ArrayList<Integer> arrayToStore = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        System.out.println("Before: " + arrayToStore.toString());
        System.out.println("After: " + storeDuplicate(arrayToStore));
        /* #7 get the number of days you have to wait
            after the i-th day to get a warmer temperature */
        System.out.println("Let's input the array of temperatures.");
        ArrayList<Integer> arrayOfTemperatures = ScannerCommandBuilder
                .getIntegerArrayFromUserInput(scanner);
        System.out.println("Before: " + arrayOfTemperatures.toString());
        System.out.println("After: "
                + Arrays.toString(getDayOfWarmerTemperature(arrayOfTemperatures)));
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

    private boolean isDuplicated(ArrayList<Integer> arrayToCheck) {
        HashMap<Integer, Integer> storedNumber = new HashMap<>();
        AtomicBoolean thereIsDuplicate = new AtomicBoolean(false);
        arrayToCheck.forEach(number -> {
            if (storedNumber.containsKey(number)) {
                thereIsDuplicate.set(true);
            }
            storedNumber.put(number, 0);
        });
        return thereIsDuplicate.get();
    }

    private ArrayList<Integer> removeDuplicate(ArrayList<Integer> arrayToFilter) {
        HashMap<Integer, Integer> storedNumber = new HashMap<>();
        ArrayList<Integer> filteredArray = new ArrayList<>();
        for (Integer integer : arrayToFilter) {
            if (!storedNumber.containsKey(integer)) {
                filteredArray.add(integer);
            }
            storedNumber.put(integer, 0);
        }
        return filteredArray;
    }

    private ArrayList<Integer> reorderArray(ArrayList<Integer> arrayToOrder,
                                            String type) {
        boolean isNeededToBeSwapped;
        for (int i = 0; i < arrayToOrder.size(); i++) {
            isNeededToBeSwapped = false;
            for (int j = 0; j < arrayToOrder.size() - 1; j++) {
                if(type.equalsIgnoreCase("asc")) {
                    if (arrayToOrder.get(j + 1) < arrayToOrder.get(j)) {
                        int temp = arrayToOrder.get(j);
                        arrayToOrder.set(j, arrayToOrder.get(j + 1));
                        arrayToOrder.set(j + 1, temp);
                        isNeededToBeSwapped = true;
                    }
                } else {
                    if (arrayToOrder.get(j + 1) > arrayToOrder.get(j)) {
                        int temp = arrayToOrder.get(j);
                        arrayToOrder.set(j, arrayToOrder.get(j + 1));
                        arrayToOrder.set(j + 1, temp);
                        isNeededToBeSwapped = true;
                    }
                }
            }
            if (!isNeededToBeSwapped) {
                break;
            }
        }
        return arrayToOrder;
    }

    private ArrayList<Integer> filterArrayByNumber(ArrayList<Integer> arrayToFilter,
                                                   int valueToRemove) {
        ArrayList<Integer> filteredArray = new ArrayList<>();
        for (Integer integer : arrayToFilter) {
            if (integer != valueToRemove) {
                filteredArray.add(integer);
            }
        }
        return filteredArray;
    }

    private void reverseString(String stringToReverse) {
        System.out.print("Reversed result: ");
        for (int i = stringToReverse.length() - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(stringToReverse.charAt(i));
            } else {
                System.out.print(stringToReverse.charAt(i));
            }
        }
    }

    private ArrayList<Integer> storeDuplicate(ArrayList<Integer> arrayToCheck) {
        HashMap<Integer, Integer> storedNumber = new HashMap<>();
        ArrayList<Integer> duplicateNumber = new ArrayList<>();
        arrayToCheck.forEach(number -> {
            if (storedNumber.containsKey(number)) {
                if(storedNumber.get(number) == 0) {
                    duplicateNumber.add(number);
                    storedNumber.put(number, 1);
                }
            } else {
                storedNumber.put(number, 0);
            }
        });
        return duplicateNumber;
    }

    private int[] getDayOfWarmerTemperature(ArrayList<Integer> arrayToCheck) {
        int[] numberDaysToWarmingUp = new int[arrayToCheck.size()];
        int numberOfDays = 0, indexOfArray = 0, previousTemperature = 0;
        for (int i = 0; i < arrayToCheck.size(); i++) {
            if (i == 0) {
                previousTemperature = arrayToCheck.get(i);
            } else if (previousTemperature > arrayToCheck.get(i)) {
                numberOfDays++;
                previousTemperature = arrayToCheck.get(i);
            } else {
                numberOfDays++;
                numberDaysToWarmingUp[indexOfArray] = numberOfDays;
                previousTemperature = arrayToCheck.get(i);
                numberOfDays = 0;
                indexOfArray++;
            }
        }
        return numberDaysToWarmingUp;
    }
}
