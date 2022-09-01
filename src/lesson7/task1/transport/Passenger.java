package lesson7.task1.transport;

public class Passenger extends Ground {

    private String bodyType;
    private int passengerCount;

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Passenger(int power, double maxSpeed, int mass, String model, int wheelCount, double fuelConsumption,
                     String bodyType, int passengerCount) {
        super(power, maxSpeed, mass, model, wheelCount, fuelConsumption);
        this.bodyType = bodyType;
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return toStringCommon() + "; количество колес: " + getWheelCount() + "шт.; расход топлива: " +
                getFuelConsumption() + "л/100км;" +  "\nтип кузова: " + getBodyType() + "; количество пассажиров: " +
                getPassengerCount() + "чел.";
    }

    public void getKm(int time) {
        double km = getMaxSpeed() * time;
        System.out.println("За время " + time + " ч, автомобиль " + getModel() + ", двигаясь с максимальной скоростью " +
                getMaxSpeed() + " км/ч, проедет " + km + " км и израсходует " + getVolume(km) + " литров топлива");
    }

    private double getVolume(double km) {
        return km * getFuelConsumption() * 0.01;
    }
}
