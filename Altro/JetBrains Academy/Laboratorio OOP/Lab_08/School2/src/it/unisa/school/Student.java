package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;

public class Student extends Person {

    /* TODO */
    private int numberOfAbsences;
    /* TODO */

    public Student(String name, String surname, int birthYear, /* TODO */int numberOfAbsences) {
        super(name, surname, birthYear/* TODO */);
        /* TODO */
        this.numberOfAbsences = numberOfAbsences;
        /* TODO */
    }

    /* TODO */

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        /* TODO */
    }

    public int getNumberOfPassedExams() {
        /* TODO */
    }

    /* TODO */

    public double getAverageGrade() {
        /* TODO */
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
