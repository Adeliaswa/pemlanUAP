package uap.mains;

import java.util.Scanner;
import uap.bases.Shape;
import uap.models.*;

public class KalkulatorPabrik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("ADELIA SWASTIKA DEWI");
        System.out.println("245150700111038");
        System.out.println("========================================");
        System.out.println("Donat dengan lubang");
        System.out.println("========================================");
        System.out.print("Isikan Radius   : ");
        double R = input.nextDouble();
        System.out.print("Isikan radius   : ");
        double r = input.nextDouble();

        Shape torus = new Torus(R, r); //membuat objek torus
        torus.printInfo();

        System.out.println("========================================");
        System.out.println("Donat tanpa lubang");
        System.out.println("========================================");
        System.out.print("Isikan radius   : ");
        double radius = input.nextDouble();

        Shape sphere = new Sphere(radius); //membuat objek sphere
        sphere.printInfo();

        System.out.println("========================================");
    }
}
