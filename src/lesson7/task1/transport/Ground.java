package lesson7.task1.transport;

public abstract class Ground extends Transport {

    private int wheelCount;
    private double fuelConsumption;

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Ground(int power, double maxSpeed, int mass, String model, int wheelCount, double fuelConsumption) {
        super(power, maxSpeed, mass, model);
        this.wheelCount = wheelCount;
        this.fuelConsumption = fuelConsumption;
    }
}
