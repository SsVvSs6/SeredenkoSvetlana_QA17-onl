package lesson6.task1;

/**
 * Создайте класс Phone, который содержит переменные number, model и weight.
 * Создайте три экземпляра этого класса.
 * Выведите на консоль значения их переменных.
 * Добавить в класс Phone методы: receiveCall, имеет один параметр – имя звонящего. Выводит на консоль сообщение
 * “Звонит {name}”. Метод getNumber – возвращает номер телефона. Вызвать эти методы для каждого из объектов.
 * Добавить конструктор, который принимает на вход два параметра для инициализации переменных класса - number, model.
 * Добавить конструктор без параметров.
 * Вызвать из конструктора с тремя параметрами конструктор с двумя.
 * Добавьте перегруженный метод receiveCall, который принимает два параметра - имя звонящего и номер телефона звонящего.
 * Вызвать этот метод.
 * Создать метод sendMessage с аргументами переменной длины. Данный метод принимает на вход номера телефонов, которым
 * будет отправлено сообщение. Метод выводит на консоль номера этих телефонов.
 */

public class Phone {

    private String number;
    private String model;
    private int weight;

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(int weight, String number, String model) {
        this.weight = weight;
        this.number = number;
        this.model = model;

        Phone newPhone = new Phone(getNumber(), getModel());
        System.out.println("Модель " + newPhone.getModel() + ", номер " + newPhone.getNumber() +
                ", вес " + getWeight());
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String number) {
        System.out.println("Звонит " + name + ", номер: " + number);
    }

    public static void sendMessage(int length, String... number) {
        System.out.println("Сообщение длиной в " + length + " символ" + getEnding(length) +
                " будет доставлено на номера: ");

        for (String phoneNumber : number) {
            System.out.println(phoneNumber);
        }
    }

    private static String getEnding(int length) {
        if (length < 21) {
            if (length == 1) {
                return "";
            } else if (length > 1 & length < 5) {
                return "а";
            } else {
                return "ов";
            }
        } else if (length % 10 == 1) {
            return "";
        } else if (length % 10 > 1 & length % 10 < 5) {
            return "а";
        } else {
            return "ов";
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
