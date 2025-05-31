package uap.models;

import uap.bases.Shape;
import uap.interfaces.*;

public class Torus extends Shape implements ThreeDimensional, MassCalculable, PIRequired, ShippingCostCalculator, MassConverter {
    private double majorRadius; //jari-jari besar torus
    private double minorRadius; //jari-jari kecil torus
    private static final int DENSITY = 8; //massa jenis dalam g/cm3
    private static final double THICKNESS = 0.5; //ketebalan torus dalam cm
    private static final int PRICE_PER_KG = 2000; //harga per kg
    private static final int DENOMINATOR = 1000; //konversi gr ke kg

    public Torus() {}

    public Torus(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double getVolume() { //untuk menghitung volume torus
        return 2 * PI * PI * majorRadius * minorRadius * minorRadius;
    }
    @Override
    public double getSurfaceArea() { //untuk menghitung luas permukaan torus
        return 4 * PI * PI * majorRadius * minorRadius;
    }
    @Override
    public double getMass() { //untuk menghitung massa berdasarkan luas permukaan, ketebalan, dan densitas
        return DENSITY * getSurfaceArea() * THICKNESS;
    }
    @Override
    public double gramToKilogram() { //untuk mengonversi massa dri gr ke kg
        return getMass() / DENOMINATOR;
    }
    @Override
    public double calculateCost() {
        return Math.ceil(gramToKilogram()) * PRICE_PER_KG; //untuk menghitung biaya pengiriman berdasarkan massa dalam kg
    }
    @Override
    public void printInfo() { //menampilkan info torus
        System.out.printf("Volume          : %.2f\n", getVolume());
        System.out.printf("Luas permukaan  : %.2f\n", getSurfaceArea());
        System.out.printf("Massa           : %.2f\n", getMass());
        System.out.printf("Massa dalam kg  : %.2f\n", gramToKilogram());
        System.out.printf("Biaya kirim     : Rp%.0f\n", calculateCost());
    }
}