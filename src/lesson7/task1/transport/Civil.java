package lesson7.task1.transport;

public class Civil extends Air {

    private int passengerCount;
    private boolean isBusiness;

    public Civil(int power, double maxSpeed, int mass, String model, int wingspan, int minRunwayLength,
                 int passengerCount, boolean isBusiness) {
        super(power, maxSpeed, mass, model, wingspan, minRunwayLength);
        this.passengerCount = passengerCount;
        this.isBusiness = isBusiness;
    }

    @Override
    public String toString() {
        return toStringCommon() + "; размах крыла: " + getWingspan() + "м; мин. длина взлетной полосы: " +
                getMinRunwayLength() + ";\nколичество пассажиров: " + getPassengerCount() + "чел.; бизнес класс: " +
                isBusiness(isBusiness);
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public String isBusiness(boolean isBusiness) {
        if (isBusiness) {
            return "есть";
        } else {
            return  "нет";
        }
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }

    public void loadAirplane(int passengers) {
        if (passengers <= getPassengerCount()) {
            System.out.println("Самолет загружен");
        } else {
            System.out.println("Вам нужен самолет побольше");
        }
    }
}
