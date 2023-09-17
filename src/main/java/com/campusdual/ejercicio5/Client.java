package com.campusdual.ejercicio5;

import com.campusdual.ejercicio5.enums.Days;

import java.util.Map;

public class Client {
    private String clientName;
    private String clientSurname;
    private Integer clientWeight;
    private Integer clientHeight;
    private Integer clientAge;
    private String clientGender;
    private Map<Days,String> dietList;

    public Client(String clientName, String clientSurname, Integer clientWeight, Integer clientHeight, Integer clientAge, String clientGender) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientWeight = clientWeight;
        this.clientHeight = clientHeight;
        this.clientAge = clientAge;
        this.clientGender = clientGender;
    }

    public Client() {

    }

    public void showClientDetails() {
        System.out.println("Datos del cliente:");
        System.out.println("Nombre: " + this.clientName);
        System.out.println("Apellidos: " + this.clientSurname);
        System.out.println("Peso: " + this.clientWeight);
        System.out.println("Altura: " + this.clientHeight);
        System.out.println("Edad: " + this.clientAge);
        System.out.println("Género: " + this.clientGender + "\n");
    }

    @Override
    public String toString() {
        return this.getClientName() + " " + this.getClientSurname();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public Integer getClientWeight() {
        return clientWeight;
    }

    public void setClientWeight(Integer clientWeight) {
        this.clientWeight = clientWeight;
    }

    public Integer getClientHeight() {
        return clientHeight;
    }

    public void setClientHeight(Integer clientHeight) {
        this.clientHeight = clientHeight;
    }

    public Integer getClientAge() {
        return clientAge;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public Map<Days, String> getDietList() {
        return dietList;
    }
}
