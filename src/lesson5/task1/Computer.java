package lesson5.task1;

import java.util.Random;

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

public class Computer {

    private boolean isOn;
    private boolean cpu;
    private boolean ram;
    private boolean hdd;
    private int workCycle;
    static Random random = new Random();

    public Computer() {
        this.cpu = getCPU();
        this.ram = getRam();
        this.hdd = getHdd();
        this.workCycle = getWorkCycle();
        this.isOn = getIsOn();

        setCpu();
        setRam();
        setHdd();
        setWorkCycle();
        setIsOn();
    }

    public void setIsOn() {
        this.isOn = random.nextBoolean();
    }

    public void setIsOn(boolean status) {
        this.isOn = status;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public void setCpu() {
        this.cpu = random.nextBoolean();
    }

    public boolean getCPU() {
        return this.cpu;
    }

    public void setRam() {
        this.ram = random.nextBoolean();
    }

    public boolean getRam() {
        return this.ram;
    }

    public void setHdd() {
        this.hdd = random.nextBoolean();
    }

    public boolean getHdd() {
        return this.hdd;
    }

    public void setWorkCycle() {
        this.workCycle = random.nextInt(20);
    }

    public void setWorkCycle(int workCycle) {
        this.workCycle = workCycle;
    }

    public int getWorkCycle() {
        return this.workCycle;
    }

    public static void main(String[] args) {

    }
}
