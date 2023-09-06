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
       initMenu();
    }
    private static void initMenu(){
        Scanner entry = new Scanner(System.in);
        System.out.println("Menú\n"+"1.Crear/reiniciar dieta\n"+"2.Mostrar información\n"+"3.Agregar alimento\n"+"4.Salir\n");
        Integer select = entry.nextInt();
        Menu sel1 = new Menu();

        switch (select){

            case 1:
                new Diet().getTotalCalories();
                //sel1.newDiet();
                break;
            case 2:
                sel1.showData();
                break;
            case 3:
                sel1.addFood();
                break;
            case 4:
                sel1.exitMenu();
                break;
            default:
                System.out.println("No ha introducido un número valido.");
                initMenu();
                break;
        }
    }
    private void newDiet() {
        Scanner entry = new Scanner(System.in);
        System.out.println("1.Crear/reiniciar dieta: crea o remplaza la dieta inicial\n"+"a.Sin límite\n"+"b.Por calorias\n"+"c.Por macronutrientes\n"+"d.Por datos personales\n");
        String select = entry.next();
        Menu sel2 = new Menu();

        switch (select) {
            case "a":
                System.out.println("Ha elegido 'Sin limite'.");
                initMenu();
                break;
            case "b":
                System.out.println("Ha elegido 'Por calorias'.");
                initMenu();
                break;
            case "c":
                System.out.println("Ha elegido 'Por macronutrientes'.");
                initMenu();
                break;
            case "d":
                System.out.println("Ha elegido 'Por datos personales'.");
                initMenu();
                break;
            default:
                System.out.println("No ha introducido un valor valido.");
                initMenu();
                break;
        }
    }
    private void showData() {
        System.out.println("2. Mostrar información: muestra calorías y macronutrientes de la dieta");
    }
    public void addFood() {
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
    private void exitMenu() {
        System.out.println("Gracias por usar nuestra aplicación. Vuelva pronto.");
    }
}
