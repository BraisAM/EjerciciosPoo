package com.campusdual.ejercicio4;

import java.util.Scanner;

/*
--Escribe un programa que utilice la clase Dieta y despliegue un menú donde puedas añadir alimentos. El menú tendrá las siguientes opciones.
	-1. Crear/reiniciar dieta: crea o remplaza la dieta inicial
		-a. Sin limite
		-b. Por calorías
		-c. Por macronutrientes
		-d. Por datos personales
	-2. Mostrar información: muestra calorías y macronutrientes de la dieta
	-3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible
		-a. Nuevo alimento
		-b. Alimento existente
	-4. Salir
*/
public class Menu {
    public static void main(String[] args) {
        mainMenu();
    }
    private static void newDiet() {
        Scanner entry = new Scanner(System.in);
        System.out.println("1.Crear/reiniciar dieta: crea o remplaza la dieta inicial\n"+"a.Sin límite\n"+"b.Por calorias\n"+"c.Por macronutrientes\n"+"d.Por datos personales\n");
        String select = entry.next();

        switch (select) {
            case "a":
                System.out.println("Ha elegido 'Sin limite'.");
                break;
            case "b":
                System.out.println("Ha elegido 'Por calorias'.");
                break;
            case "c":
                System.out.println("Ha elegido 'Por macronutrientes'.");
                break;
            case "d":
                System.out.println("Ha elegido 'Por datos personales'.");
                break;
            default:
                System.out.println("No ha introducido un valor valido.");
                break;
        }
        mainMenu();
    }
    private static void showData() {
        System.out.println("2. Mostrar información: muestra calorías y macronutrientes de la dieta");
    }
    public static void addFood() {
        Scanner entry = new Scanner(System.in);
        System.out.println("3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible\n"+"a.Nuevo alimento\n"+"b.Alimento existente\n");
        String select = entry.next();
        switch (select){
            case "a":
                System.out.println("Ha elegido 'Nuevo alimento'. Escriba el alimento que desea añadir:\n");
                break;
            case "b":
                System.out.println("Ha elegido 'Alimento existente'.");
                break;
            default:
                System.out.println("No ha introducido un valor valido.");
                break;
        }
    }
    private static void exitMenu() {
        System.out.println("Gracias por usar nuestra aplicación. Vuelva pronto.");
    }
    private static void mainMenu(){
        Scanner entry = new Scanner(System.in);
        System.out.println("Menú\n"+"1.Crear/reiniciar dieta\n"+"2.Mostrar información\n"+"3.Agregar alimento\n"+"4.Salir\n");
        Integer select = entry.nextInt();

        switch (select){

            case 1:
                newDiet();
                break;
            case 2:
                showData();
                break;
            case 3:
                addFood();
                break;
            case 4:
                exitMenu();
                break;
            default:
                System.out.println("No ha introducido un número valido.");
                mainMenu();
                break;
        }
    }
}
