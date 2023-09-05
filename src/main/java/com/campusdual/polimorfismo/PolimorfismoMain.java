package com.campusdual.polimorfismo;

public class PolimorfismoMain {
    public static void main(String[] args){
        Vehiculo misVehiculos[] = new Vehiculo[4];

        misVehiculos[0] = new Vehiculo("3743BKS","Opel","Manta");
        misVehiculos[1] = new VehiculoTurismo(3,"6284FGB","Ford","Fiesta ST");
        misVehiculos[2] = new VehiculoDeportivo(525,"6273LCK","Porsche","911 GT3 RS");
        misVehiculos[3] = new VehiculoFurgoneta(1450,"8254KFR","Peugeot","Partner");

        for(Vehiculo vehiculos: misVehiculos){
            System.out.println(vehiculos.mostrarDatos());
            System.out.println("");
        }
    }
}
