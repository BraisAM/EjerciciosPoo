package com.campusdual.polimorfismo;

public class VehiculoDeportivo extends Vehiculo {
    private int potencia;

    public VehiculoDeportivo(int potencia, String matricula, String marca, String modelo){
        super(matricula, marca, modelo);
        this.potencia = potencia;
    }

    public int getPotencia(){
        return potencia;
    }

    @Override
    public String mostrarDatos(){
        return "Matricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nPotencia: " + potencia + "cv";
    }
}
