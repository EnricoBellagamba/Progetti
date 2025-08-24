package org.example;
public class Triangolo {
    public static void main(String[] args) {
        double base = 13.0;
        double altezza = 33.0;
        double area = calcolaAreaTriangolo(base, altezza);
        System.out.println(area);
    }

    public static double calcolaAreaTriangolo(double base, double altezza){
        double area = 0;
        area = (base * altezza) / 2;
        return area;
    }
}