package uap.models;

import uap.bases.Shape;
import uap.interfaces.*;

public class Sphere extends Shape implements ThreeDimensional, MassCalculable, PIRequired, ShippingCostCalculator, MassConverter {
    private double radius; //jari-jari bola
    private static final int DENSITY = 8;
    private static final double THICKNESS = 0.5; //ketebalan bola
    private static final int PRICE_PER_KG = 2000;
    private static final int DENOMINATOR = 1000;

    public Sphere() {}

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() { //untuk menghitung volume bola
        return 4.0 / 3.0 * PI * radius * radius * radius;
    }
    @Override
    public double getSurfaceArea() { //untuk menghitung luas permukaan bola
        return 4 * PI * radius * radius;
    }
    @Override
    public double getMass() {
        return DENSITY * getSurfaceArea() * THICKNESS;
    }
    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }
    @Override
    public double calculateCost() {
        return Math.ceil(gramToKilogram()) * PRICE_PER_KG;
    }
    @Override
    public void printInfo() { //menampilkan info sphere
        System.out.printf("Volume          : %.2f\n", getVolume());
        System.out.printf("Luas permukaan  : %.2f\n", getSurfaceArea());
        System.out.printf("Massa           : %.2f\n", getMass());
        System.out.printf("Massa dalam kg  : %.2f\n", gramToKilogram());
        System.out.printf("Biaya kirim     : Rp%.0f\n", calculateCost());
    }
}