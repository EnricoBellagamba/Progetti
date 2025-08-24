package it.unisa.company;

public class Manager extends Employee {

    private String expertiseArea;
    private int workedHours;

    /* TODO */

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    /* TODO */

    /* TODO */

    /* TODO */

    @Override
    public String toString() {
        return super.toString() +
                ", Area di competenza='" + expertiseArea + '\'';
    }
}
