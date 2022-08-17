package lesson4.task1;

import java.util.Random;
import java.util.Scanner;

/**
 * Ввести с клавы размер 2-ухмерного массива. Оба значения. Вычесть из суммы элементов 2 строки сумму побочной
 * диоганали… НО, если матрица не квадратная, то всместо диоганали – сумму 2 столбца. ГЫ
 * Вывести на экран изначальную матрицу. Значения заполнить рандомом, ограничив до легчосчитаемого но не ниже
 * значения 5.
 * Вывести каждую сумму отдельно (с пояснение, что оно такое)
 * Вывести итоговый ответ.
 * Для звёздочки, если квадратная - вывести  индекс и значение ее центра, если центр невыявляем, сделать матрицу
 * пригодной (удалить столбец справа и предпоследнюю строку)  для этого и вывести получившуюся. А если неквадратная –
 * сделать ее размер равным наименшему значению и найти центр.
 */

public class Task1 {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Введи количество строк : ");
        int lineNumber = scanner.nextInt();
        System.out.print("Введи количество столбцов : ");
        int columnNumber = scanner.nextInt();
        int[][] matrix = new int[lineNumber][columnNumber];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(5);
            }
        }

        outMatrix(matrix);
        if (lineNumber > 1 & columnNumber > 1) {
            int difference = secondLineSumm(matrix) - diagonalSumm(matrix, lineNumber, columnNumber);
            System.out.println("Разность сумм: " + difference);
        }
        else {
            System.out.println("Ваша матрица содержит один столбец или одну строку");
        }

    }

    private static int diagonalSumm(int[][] matrix, int lineNumber, int columnNumber) {

        if (columnNumber == lineNumber) {
            int dioganalSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                dioganalSum += matrix[matrix.length - 1 - i][i];
            }
            System.out.println("Сумма диагонали равна: " + dioganalSum);

            return dioganalSum;
            }
        else {
            int secondColumnSumm = 0;
            for (int i = 0; i < matrix.length; i++) {
                secondColumnSumm += matrix[i][1];
            }
            System.out.println("Сумма второго столбца равна: " + secondColumnSumm);

            return secondColumnSumm;
        }
         }

    private static int secondLineSumm(int[][] matrix) {

        int secondLineSumm = 0;
        for (int i = 0; i < matrix.length; i++) {
            secondLineSumm += matrix[1][i];
        }
        System.out.println("Сумма второй строки равна: " + secondLineSumm);

        return secondLineSumm;
    }

    public static void outMatrix(int[][] matrix) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
