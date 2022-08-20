package lesson5.task1;

import java.util.Scanner;
import static lesson5.task1.Computer.random;

/**
 * Почитать Object, String на JavaDoc
 * Создать класс компьютер.
 * Поля:
 * isOn boolean
 * 	- процессор    Boolean
 * 	- оперативка Boolean
 * 	- жесткий диск Boolean
 * 	- ресурс полных циклов работы (включений/выключений) int
 * Методы:
 * 	- метод описание(вывод всех полей)
 * вывод:  [“есть”, “есть”, “есть”, 18 циклов]
 * 	- метод включить, при включении может произойти сбой, при вызове метода
 * рандом загадывает число (0 либо 1), вы вводите число с клавиатуры, если
 * угадали комп включается, если нет сгорает. Если комп сгорел, при попытке
 * включить нужно выдать сообщение что ему конец
 * 	- выключить (аналогично включению)
 * 	- при превышении лимита ресурса комп сгорает
 */

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int boughtComputers = random.nextInt(10);
        String computerDeclination;
        if (boughtComputers == 1) {
            computerDeclination = "компьютер";
        } else if (boughtComputers > 1 & boughtComputers < 5) {
            computerDeclination = "компьютера";
        } else {
            computerDeclination = "компьютеров";
        }
        System.out.println("Ваша компания закупила " + boughtComputers + " " + computerDeclination);
        System.out.println();
        for (int i = 0; i < boughtComputers; i++) {
            System.out.println("Компьютер №" + (i + 1));
            getDescriptionComputer();
            System.out.println();
        }
    }

    private static void getDescriptionComputer() {

        String cpuValue;
        String ramValue;
        String hddValue;
        String cycleDeclination;
        Computer newComputer = new Computer();
        if (newComputer.getCPU()) {
            cpuValue = "есть";
        } else {
            cpuValue = "нет";
        }
        if (newComputer.getRam()) {
            ramValue = "есть";
        } else {
            ramValue = "нет";
        }
        if (newComputer.getHdd()) {
            hddValue = "есть";
        } else {
            hddValue = "нет";
        }
        if (newComputer.getWorkCycle() == 1) {
            cycleDeclination = "цикл";
        } else if (newComputer.getWorkCycle() > 1 & newComputer.getWorkCycle() < 5) {
            cycleDeclination = "цикла";
        } else {
            cycleDeclination = "циклов";
        }

        System.out.println("[\"" + cpuValue + "\", \"" + ramValue + "\", \"" + hddValue + "\" , "
                + newComputer.getWorkCycle() + " " + cycleDeclination + "]");

        if (getWorkStatus(newComputer)) {
            while (newComputer.getWorkCycle() > 0) {
                if (getIsOnStatus(newComputer)) {
                    turnOffComputer(newComputer);
                } else {
                    turnOnComputer(newComputer);
                }
            }
        }
    }

    private static void turnOffComputer(Computer newComputer) {

        int randomToOff = random.nextInt(2);
        System.out.print("Введите 1 или 0: ");
        int scannerToOff = scanner.nextInt();
        if (randomToOff == scannerToOff) {
            newComputer.setIsOn(false);
            newComputer.setWorkCycle(newComputer.getWorkCycle() - 1);
            System.out.println("Осталось циклов: " + newComputer.getWorkCycle());
        } else {
            brokenComputer(newComputer);
        }

    }

    private static void brokenComputer(Computer newComputer) {

        newComputer.setWorkCycle(0);
        System.out.println("Компьютер сломан, осталось циклов: " + newComputer.getWorkCycle());
    }

    private static void turnOnComputer(Computer newComputer) {

        int randomToOn = random.nextInt(2);
        System.out.print("Введите 1 или 0: ");
        int scannerToOn = scanner.nextInt();
        if (randomToOn == scannerToOn) {
            newComputer.setIsOn(true);
        } else {
            brokenComputer(newComputer);
        }
    }

    private static boolean getWorkStatus(Computer newComputer) {

        boolean workStatus;
        if (newComputer.getCPU() & newComputer.getRam() & newComputer.getHdd() & newComputer.getWorkCycle() > 0) {
            workStatus = true;
            System.out.println("Компьютер в рабочем состоянии");
        } else {
            workStatus = false;
            System.out.println("Компьютер не в рабочем состоянии");
        }

        return workStatus;
    }

    private static boolean getIsOnStatus(Computer newComputer) {

        if (newComputer.getIsOn()) {
            System.out.println("Компьютер включен");
        } else {
            System.out.println("Компьютер выключен");
        }

        return newComputer.getIsOn();
    }
}
