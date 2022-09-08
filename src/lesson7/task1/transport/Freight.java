package lesson7.task1.transport;

public class Freight extends Ground {

    private int loadCapacity;

    public Freight(int power, double maxSpeed, int mass, String model, int loadCapacity, int wheelCount,
                   double fuelConsumption) {
        super(power, maxSpeed, mass, model, wheelCount, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return toStringCommon() + "; количество колес: " + getWheelCount() + "шт.; расход топлива: " +
                getFuelConsumption() + "л/100км" + "\nгрузоподъемность: " + getLoadCapacity() + "т.";
    }

    public void loadTruck(int cargo) {
        if (cargo <= getLoadCapacity()) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }
}
