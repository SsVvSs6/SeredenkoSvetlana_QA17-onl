package lesson7.task1.transport;

public abstract class Air extends Transport {

    private int wingspan;
    private int minRunwayLength;

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getMinRunwayLength() {
        return minRunwayLength;
    }

    public void setMinRunwayLength(int minRunwayLength) {
        this.minRunwayLength = minRunwayLength;
    }

    public Air(int power, double maxSpeed, int mass, String model, int wingspan, int minRunwayLength) {
        super(power, maxSpeed, mass, model);
        this.wingspan = wingspan;
        this.minRunwayLength = minRunwayLength;
    }
}
