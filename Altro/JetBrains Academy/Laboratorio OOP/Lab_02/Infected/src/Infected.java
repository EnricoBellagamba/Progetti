public class Infected {

    private final String disease;
    private int numberOfInfected;

    public Infected(String disease) {
        this.disease = disease;
        this.numberOfInfected = 0;
    }

    public Infected(String disease, int numberOfInfected) {
        this.disease = disease;
        this.numberOfInfected = numberOfInfected;
    }

    public int getNumberOfInfected() {
        return numberOfInfected;
    }

    public String getDisease() {
        return disease;
    }

    public void addInfected(int numberOfInfected) {
        int newInfected =+ numberOfInfected;
    }

    public void updateInfectedByRt(double Rt) {
        numberOfInfected = (int) (numberOfInfected * Rt);
    }
}