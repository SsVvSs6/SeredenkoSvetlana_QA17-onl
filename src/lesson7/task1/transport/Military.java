package lesson7.task1.transport;

public class Military extends Air {

    private boolean isCatapult;
    private int rocketCount;

    public Military(int power, double maxSpeed, int mass, String model, int wingspan, int minRunwayLength,
                    boolean isCatapult, int rocketCount) {
        super(power, maxSpeed, mass, model, wingspan, minRunwayLength);
        this.isCatapult = isCatapult;
        this.rocketCount = rocketCount;
    }

    @Override
    public String toString() {
        return toStringCommon() + "; размах крыла: " + getWingspan() + "м; мин. длина взлетной полосы: " +
                getMinRunwayLength() + ";\nкатапульта: " + isCatapult(isCatapult) + "; количество ракет: " +
                getRocketCount() + "шт.";
    }

    public void rocketShot() {
        if (getRocketCount() > 0) {
            System.out.println("Ракета пошла...");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void makeCatapult() {
        if (isCatapult) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У вас нет такой системы");
        }
    }

    public boolean isCatapult() {
        return isCatapult;
    }

    public String isCatapult(boolean isCatapult) {
        if (isCatapult) {
            return "есть";
        } else {
            return  "нет";
        }
    }

    public void setCatapult(boolean catapult) {
        isCatapult = catapult;
    }

    public int getRocketCount() {
        return rocketCount;
    }

    public void setRocketCount(int rocketCount) {
        this.rocketCount = rocketCount;
    }
}
