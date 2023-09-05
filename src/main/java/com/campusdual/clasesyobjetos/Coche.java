package com.campusdual.clasesyobjetos;

public class Coche {
    //Atributos
    String marca;
    String modelo;
    String color;
    Integer km;

    public static void main(String[] args) {
        Coche coche1 = new Coche();

        coche1.marca = "Opel";
        coche1.modelo = "Manta";
        coche1.color = "Rojo";
        coche1.km = 135245;

        System.out.println("El coche 1 es un: " + coche1.marca + " " + coche1.modelo);
        System.out.println("El color del coche 1 es: "+ coche1.color);
        System.out.println("El kilometraje del coche 1 es: "+ coche1.km);

        Coche coche2 = new Coche();

        coche2.marca = "Ford";
        coche2.modelo = "Escort";
        coche2.color = "Azul";
        coche2.km = 25374;

        System.out.println("\nEl coche 2 es un: " + coche2.marca + " " + coche2.modelo);
        System.out.println("El color del coche 2 es: "+ coche2.color);
        System.out.println("El kilometraje del coche 2 es: "+ coche2.km);
    }
}
