package it.unisa.company;

public class Employee /* TODO */ {

    private String jobTitle;
    private float hourlyWage;

    /* TODO */

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    /* TODO */

    /* TODO */

    @Override
    public String toString() {
        return super.toString() +
                ", Incarico='" + jobTitle + '\'';
    }
}
