package lesson6.task1;

import java.util.Random;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {

        Phone iPhone = new Phone(62, "1234567", "Apple");
        Phone samsung = new Phone(55, "7654321", "Samsung");
        Phone xiaomi = new Phone(23, "0987654", "Xiaomi");

        System.out.println();
        Phone[] array = new Phone[] {iPhone, samsung, xiaomi};
        for (int i = 0; i < array.length; i++) {
            array[i].receiveCall("Name" + (i + 1));
            System.out.println(array[i].getNumber());
        }
        System.out.println();
        samsung.receiveCall("Name4", array[random.nextInt(3)].getNumber());
        System.out.println();
        Phone.sendMessage(random.nextInt(1000), iPhone.getNumber(), samsung.getNumber(), xiaomi.getNumber());
    }
}
