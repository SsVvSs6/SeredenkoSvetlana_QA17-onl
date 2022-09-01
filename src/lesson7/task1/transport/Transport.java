package lesson7.task1.transport;

public abstract class Transport {

    private int power;
    private double maxSpeed;
    private int mass;
    private String model;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Transport(int power, double maxSpeed, int mass, String model) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.mass = mass;
        this.model = model;
    }

    public double transferPower(int power) {
        return (double) power * 0.74;
    };

    public String toStringCommon() {
        return "Мощность: " + getPower() + "л.с., " + transferPower(getPower()) + "кВ; максимальная скорость: " +
                getMaxSpeed() + "км/ч; масса: " + getMass() + "кг; модель: " + getModel();
    }
}
