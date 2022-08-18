package lesson3.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Постройте частотный словарь букв русского (или английского) алфавита.
 * Т.е. Сколько раз каждая бука алфавита повторяется в введенной строке.
 * Alphabet.put(“A”, 0)
 */

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value: ");
        String enteredValue = scanner.nextLine().toLowerCase();

        String abc = "abcdefjhijklnmopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter : abcArray) {
            alphabet.add(letter);
        }

        for (Character characterAbcArray : alphabet) {
            int count = 0;
                for (int i = 0; i < enteredValue.length(); i++) {
                    if (enteredValue.charAt(i) == characterAbcArray) {
                        count++;
                    }
            }
            System.out.println(characterAbcArray + " \u2192 " + count);
        }
    }
}
