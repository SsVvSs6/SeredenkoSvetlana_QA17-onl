package lesson3.task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Создать программу, которая позволяет ввести с клавиатуры массив размером n и отсортировать его по
 * убыванию. Т.е.:
 * 1 Нужно считать с клавиатуры значение числа "n"(размер массива), используя метод makeMassiveUsingKeybord();
 * 2.1 Ввести значения, которые будут добавлены в массив (при размере массива, равном «n», необходимо ввести
 * элементы массива «n» раз).
 * Example: Выводит на экран строку типа:
 * Enter element [номер элемента]: {Введенное с клавиатуры целое число}
 * 2.2 Далее вывести массив, который мы создали, каждый элемент через запятую и пробел, используя метод
 * printMassive()}.
 * Example: 7, 23, 12, 0, 322
 * 3 Отсортировать базовый массив по убыванию сортировкой Пузырька, используя метод sortMassiveByBubbleWay()}.
 * 4 Вывести отсортированный массив, используя метод printSortedDescMassive()}.
 * Example: [322, 23, 12, 7, 0]
 */

public class Task1 {

    public static void main(String[] args) {
        int[] baseMassive = makeMassiveUsingKeybord();
        System.out.println("Your base massive is:");
        System.out.println(printMassive(baseMassive));
        System.out.println("Sorted massive DESK:");
        System.out.println(printSortedDescMassive(baseMassive));
    }

    private static int[] makeMassiveUsingKeybord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter massive size : \u2192 ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Enter element " + i +": ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static String printMassive(int[] baseMassive) {

        return Arrays.toString(baseMassive)
        .replace("[", "")
        .replace("]", "");
    }

    private static int[] sortMassiveByBubbleWay(int[] baseMassive) {
        for (int i = 0; i < baseMassive.length; i++) {
            for (int j = 0; j < baseMassive.length - 1; j++) {
                if (baseMassive[j] > baseMassive[j + 1]) {
                    int temp = baseMassive[j];
                    baseMassive[j] = baseMassive[j + 1];
                    baseMassive[j + 1] = temp;
                }
            }
        }

        return baseMassive;
    }

    private static String printSortedDescMassive(int[] baseMassive) {
        int[] array = sortMassiveByBubbleWay(baseMassive);

        return Arrays.toString(array);
    }
}
