package com.softserve.edu.homeworkjava2.task3;

import java.util.*;

public class Task3 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        fillListWithRandomElements(numbers, 20);
        printCollection(numbers);

        System.out.println("Min number: " + minNumber(numbers));
        System.out.println("Max number: " + maxNumber(numbers));
        System.out.println("Average number is " + averageNumber(numbers));

        removeEvenNumbers(numbers);
        printCollection(numbers);

        System.out.println(containsNumber(numbers, 5));
        sort(numbers);
        printCollection(numbers);
    }

    public static void fillListWithRandomElements(List<Integer> list, int elementsNumber) {
        Random random = new Random();
        for (int i = 0; i < elementsNumber; i++) {
            int element = random.nextInt(0, 101);
            list.add(element);
        }
    }

    public static int minNumber(List<Integer> list) {
        return list.stream()
            .min(Comparator.naturalOrder())
            .orElseThrow();
    }

    public static int maxNumber(List<Integer> list) {
        return list.stream()
            .max(Comparator.naturalOrder())
            .orElseThrow();
    }

    public static double averageNumber(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum = sum + element;
        }
        return sum * 1.0 / list.size();
    }

    public static void removeEvenNumbers(List<Integer> list) {
        list.removeIf(element -> element % 2 == 0);
    }

    public static boolean containsNumber(List<Integer> list, int number) {
        return list.contains(number);
    }

    public static void sort(List<Integer> list) {
        Collections.sort(list);
    }

    public static void printCollection(Collection<Integer> collection) {
        System.out.println(collection);
    }
}
