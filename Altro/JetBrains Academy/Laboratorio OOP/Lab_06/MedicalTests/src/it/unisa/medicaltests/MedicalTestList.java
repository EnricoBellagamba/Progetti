package it.unisa.medicaltests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class MedicalTestList {

    private final List<MedicalTest> medicalTestList;

    public MedicalTestList() {
        this.medicalTestList = new ArrayList<>();
    }

    public void addMedicalTest(MedicalTest mt) {
        /* TODO */
    }

    public List<MedicalTest> getMedicalTestByDate(GregorianCalendar date) {
        /* TODO */
    }

    public List<MedicalTest> getMedicalTestByDoctor(String doctorName) {
        /* TODO */
    }

    public double getAverageCost() {
        /* TODO */
    }

    public List<MedicalTest> getMedicalTestList() {
        return medicalTestList;
    }
}
