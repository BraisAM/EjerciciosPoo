package com.campusdual.ejercicio4;

import java.util.ArrayList;
import java.util.List;
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
    private static void mainMenu(){
        Scanner entry = new Scanner(System.in);
        Integer select = null;
        Diet dieta = null;
        List<Food> listFood = new ArrayList<>();
        do {
            System.out.println("Menú\n"+"1.Crear/reiniciar dieta\n"+"2.Mostrar información\n"+"3.Agregar alimento\n"+"4.Salir\n");
            select = entry.nextInt();
            switch (select) {
                case 1:
                    dieta = newDiet();
                    break;
                case 2:
                    showData(dieta);
                    break;
                case 3:
                    addFood(dieta, listFood);
                    break;
                case 4:
                    exitMenu();
                    break;
                default:
                    System.out.println("No ha introducido un número valido.");
                    break;
            }
        }
        while (select != 4);
    }
    private static Diet newDiet() {
        Scanner entry = new Scanner(System.in);
        System.out.println("1.Crear/reiniciar dieta: crea o remplaza la dieta inicial\n"+"a.Sin límite\n"+"b.Por calorias\n"+"c.Por macronutrientes\n"+"d.Por datos personales\n");
        String select = entry.next();
        Diet newDiet = null;

        switch (select) {
            case "a":
                System.out.println("Ha elegido 'Sin limite'.");
                newDiet = new Diet();
                break;
            case "b":
                System.out.println("Ha elegido 'Por calorias'. Ingrese el número de calorias:");
                Integer calories = entry.nextInt();
                newDiet = new Diet(calories);
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
        return newDiet;
    }
    private static void showData(Diet dieta) {
        System.out.println("Numero total de carbos: " + dieta.getTotalCarbs());
        System.out.println("2. Mostrar información: muestra calorías y macronutrientes de la dieta");
    }
    public static void addFood(Diet dieta, List<Food> listFood) {
        Scanner entry = new Scanner(System.in);
        System.out.println("3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible\n"+"a.Nuevo alimento\n"+"b.Alimento existente\n");
        String select = entry.next();
        switch (select){
            case "a":
                System.out.println("Ha elegido 'Nuevo alimento'. Escriba el alimento que desea añadir:\n");
                String foodName = entry.next();
                Food newFood = new Food(0, 0, 0, foodName);
                listFood.add(newFood);
                dieta.addFood(newFood, 100);
                break;
            case "b":
                System.out.println("Ha elegido 'Alimento existente'. Seleccione un alimento.\n");
                for (int i = 0; i < listFood.size(); i++) {
                    System.out.println(i + ". " + listFood.get(i).getFoodName());
                }
                Integer selectFood = null;
                do {
                    selectFood = entry.nextInt();
                    if (selectFood < 0 || selectFood >= listFood.size()){
                        System.out.println("Ingrese un numero valido entre 0 y " + (listFood.size()-1) + ":\n");
                    }
                }
                while (
                    selectFood < 0 || selectFood >= listFood.size()
                );
                Food alimento = listFood.get(selectFood);
                System.out.println("Escriba la cantidad que desea añadir en gramos:\n");
                Integer selectQuant = entry.nextInt();
                dieta.addFood(alimento,selectQuant);
                break;
            default:
                System.out.println("No ha introducido un valor valido.");
                break;
        }
    }
    private static void exitMenu() {
        System.out.println("Gracias por usar nuestra aplicación. Vuelva pronto.");
    }
}
