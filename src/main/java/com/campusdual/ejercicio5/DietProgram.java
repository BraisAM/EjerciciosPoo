package com.campusdual.ejercicio5;

import com.campusdual.ejercicio5.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DietProgram {
    private List<Food> foodList;
    private List<Client> clientsList;
    //private List<Diet> dietsList;
    private HashMap<String, Diet> dietsList;
    private Client activeClient;
    private String activeDiet;

    public DietProgram(){
        foodList = new ArrayList<>();

        //Inicializacion alimentos predefinidos

        Food tofu = new Food("Tofu", 1, 7, 11);
        Food garbanzos = new Food("Garbanzos", 30, 3, 10);
        Food seitan = new Food("Seitan", 4, 2, 25);
        Food espinacas = new Food("Espinacas", 1, 0, 1);
        Food lentejas = new Food("Lentejas", 60, 1, 26);
        Food arroz = new Food("Arroz", 28, 0, 3);
        Food macarrones = new Food("Macarrones", 74, 2, 12);
        foodList.add(tofu);
        foodList.add(garbanzos);
        foodList.add(seitan);
        foodList.add(espinacas);
        foodList.add(lentejas);
        foodList.add(arroz);
        foodList.add(macarrones);
        clientsList = new ArrayList<>();
        dietsList = new HashMap<>();

        //Inicializacion alimentos predefinidos
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public HashMap<String, Diet> getDietsList() {
        return dietsList;
    }

    public void setDietsList(HashMap<String, Diet> dietsList) {
        this.dietsList = dietsList;
    }

    public void showMenuProgram(){
        System.out.println("\n" +
                "█▀█ █▀█ █▀█ █▀▀ █▀█ ▄▀█ █▀▄▀█ ▄▀█   █▀▄ █▀▀   █▀▄ █ █▀▀ ▀█▀ ▄▀█ █▀\n" +
                "█▀▀ █▀▄ █▄█ █▄█ █▀▄ █▀█ █░▀░█ █▀█   █▄▀ ██▄   █▄▀ █ ██▄ ░█░ █▀█ ▄█");
        Integer option;
        do{
            System.out.println("@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@  Menú principal  @");
            System.out.println("@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Escriba una opción:");
            System.out.println("====================");
            System.out.println("1-Dietas");
            System.out.println("2-Clientes");
            System.out.println("3-Salir del programa");
            System.out.println("====================");
            option = Kb.getOption(1,3);
            switch (option){
                case 1:
                    dietsMenu();
                    break;
                case 2:
                    clientsMenu();
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa, hasta pronto ⊂(◉‿◉)つ");
                    break;
            }
        }while(option != 3);
    }

    private void dietsMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@      Dietas      @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@");
        if (activeDiet != null){
            System.out.println("Dieta activa '" + activeDiet + "'");
        } else System.out.println("No hay dieta activa.");
        System.out.println("Escriba una opción:");
        System.out.println("====================");
        System.out.println("1-Lista de dietas");
        System.out.println("2-Buscar dieta");
        System.out.println("3-Nueva dieta");
        System.out.println("4-Dieta activa");
        System.out.println("5-Volver");
        System.out.println("====================");
        Integer option = Kb.getOption(1,5);
        switch (option){
            case 1:
                selectDiet();
                break;
            case 2:
                searchDiet();
                break;
            case 3:
                createDietMenu();
                break;
            case 4:
                if (activeDiet == null){
                    System.out.println("Primero debe seleccionar una dieta.");
                } else activeDietMenu();
                break;
            case 5:
                break;
        }
    }
    private void selectDiet(){
        if (dietsList.isEmpty()){
            System.out.println("No tienes ninguna dieta creada.");
        } else {
            System.out.println("Lista de dietas:");
            for (String dietName : dietsList.keySet()) {
                System.out.println("- " + dietName);
            }
            String select = Kb.nextLine("Seleccione una dieta:");
            activeDiet = select; // Almacena solo la clave
            System.out.println("Has seleccionado '" + activeDiet + "'");

            activeDietMenu();
        }
    }
    private void searchDiet(){
        String searchDiet = Kb.nextLine("Escribe el nombre de la dieta:");
        if (dietsList.get(searchDiet) == null){
            System.out.println("La dieta que busca no existe.");
        } else {
            System.out.println("Dieta seleccionada: " + searchDiet);
            activeDiet = searchDiet;

            activeDietMenu();
        }
    }
    private void createDietMenu() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@         Crear dieta       @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("=============================");
        System.out.println("1-Dieta sin límite");
        System.out.println("2-Dieta por calorías");
        System.out.println("3-Dieta por macronutrientes");
        System.out.println("4-Dieta por datos personales");
        Integer option = Kb.getOption(1,4);
        switch (option){
            case 1:
                Diet diet = new Diet();
                String dietName = Kb.nextLine("Nombre de la dieta:");
                dietsList.put(dietName, diet);
                System.out.println("Se ha creado una dieta sin límites llamada '" + dietName + "'");
                activeDiet = dietName;

                activeDietMenu();
                break;
            case 2:
                String dietNameCal = Kb.nextLine("Nombre de la dieta:");
                Integer calories = Kb.forceNextInt("Escriba el numero de calorias:");
                Diet dietCal = new Diet(calories);
                dietsList.put(dietNameCal, dietCal);
                System.out.println("Se ha creado una dieta con " + calories + " calorías máximas llamada '" + dietNameCal + "'");
                activeDiet = dietNameCal;

                activeDietMenu();
                break;
            case 3:
                System.out.println("Dieta por macronutrientes");
                System.out.println("=========================");
                String dietNameMacro = Kb.nextLine("Nombre de la dieta:");
                Integer macrosCarbs = Kb.forceNextInt("Numero de carbohidratos:");
                Integer macrosFats = Kb.forceNextInt("Numero de grasas:");
                Integer macrosProt = Kb.forceNextInt("Numero de proteinas:");
                Diet dietMacro = new Diet(macrosFats, macrosCarbs, macrosProt);
                dietsList.put(dietNameMacro, dietMacro);
                System.out.println("Se ha creado una dieta con:" +
                        "\n-"+ macrosCarbs + "gr de carbohidratos" +
                        "\n-" + macrosFats + "gr de grasas" +
                        "\n-" + macrosProt + "gr de proteinas\n");
                activeDiet = dietNameMacro;

                activeDietMenu();
                break;
            case 4:
                if (activeClient == null){
                    System.out.println("Primero debe seleccionar un cliente");
                } else {
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("@  Datos personales del cliente  @");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    String dietNameBasal = Kb.nextLine("Nombre de la dieta:");
                    Integer weight = activeClient.getClientWeight();
                    Integer height = activeClient.getClientHeight();
                    Integer age = activeClient.getClientAge();
                    String sexCharacter = activeClient.getClientGender();
                    Diet dietBasal = new Diet("m".equalsIgnoreCase(sexCharacter), age, height, weight);
                    dietsList.put(dietNameBasal, dietBasal);
                    System.out.println("Se ha creado una dieta de " + dietBasal.getMaxCalories() + " calorías máximas con los datos de " + activeClient);
                    activeDiet = dietNameBasal;

                    activeDietMenu();
                }
                break;
        }
    }
    private void activeDietMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@       Dieta      @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Dieta '" + activeDiet + "'");
        System.out.println("Escriba una opción:");
        System.out.println("====================");
        System.out.println("1-Detalles de la dieta");
        System.out.println("2-Añadir alimento");
        System.out.println("3-Modificar dieta");
        System.out.println("4-Eliminar dieta");
        System.out.println("5-Volver");
        System.out.println("====================");
        Integer option = Kb.getOption(1,5);
        switch (option){
            case 1:
                showDietDetails();
                break;
            case 2:
                addFoodMenu();
                break;
            case 3:
                modifyDiet();
                break;
            case 4:
                deleteDiet();
                break;
            case 5:
                break;
        }
    }
    private void showDietDetails() {
        Diet diet = dietsList.get(activeDiet); // Accede al valor correspondiente en el mapa
        // Ahora puedes trabajar con la dieta seleccionada
        if (diet == null) {
            System.out.println("La dieta seleccionada no existe.");
            return;
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@       Detalles de la dieta      @");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            // Mostrar los alimentos (intakes) de la dieta
            List<Intake> intakes = diet.getIntakes();
            if (intakes.isEmpty()) {
                System.out.println("La dieta no contiene alimentos.\n");
            } else {
                System.out.println("Número de alimentos de la dieta: " + diet.getFoodNumber());
                System.out.println("Calorías: " + diet.getTotalCalories());
                System.out.println("Carbohidratos: " + diet.getTotalCarbs());
                System.out.println("Grasas: " + diet.getTotalFats());
                System.out.println("Proteínas: " + diet.getTotalProteins());
                System.out.println("Alimentos de la dieta: \n" + diet.getDietIntakes());
                if (diet.getMaxCalories() != null) {
                    System.out.println("El número máximo de calorías es:" + diet.getMaxCalories());
                }
                if (diet.getMaxCarbs() != null || diet.getMaxFats() != null || diet.getMaxProteins() != null) {
                    System.out.println("Los valores máximos de macronutrientes son:\n" +
                            "Carbohidratos: " + diet.getMaxCarbs() + "gr\n" +
                            "Grasas: " + diet.getMaxFats() + "gr\n" +
                            "Proteinas: " + diet.getMaxProteins() + "gr\n");
                }
            }
        }
    }
    private void addFoodMenu() {
        Integer option;
        Diet diet = dietsList.get(activeDiet);
        if(diet==null){
            System.out.println("Para agregar alimentos hace falta seleccionar una dieta");
            return;
        }
        do {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@   Agregar alimentos a la dieta  @");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Dieta '" + activeDiet + "'");
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Agregar un nuevo alimento");
            System.out.println("2-Agregar un alimento ya existente");
            System.out.println("3-Volver");
            System.out.println("===================================");
            option = Kb.getOption(1,3);
            switch (option) {
                case 1:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("@    Datos de nuevo alimento    @");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    String name = Kb.nextLine("Nombre del alimento:");
                    Integer carbs = Kb.forceNextInt("Carbohidratos:");
                    Integer fats = Kb.forceNextInt("Grasas:");
                    Integer proteins = Kb.forceNextInt("Proteínas:");
                    Integer grams = Kb.forceNextInt("Gramos:");
                    Food newFood = new Food(name, carbs, fats, proteins);
                    validateAndAddFoodToDiet(newFood,grams);
                    foodList.add(newFood);
//                    System.out.println("Se han añadido " + grams + " gramos de " + newFood.getName() + " a la dieta '" + activeDiet + "'");
//                    try {
//                        diet.addFood(newFood, grams);
//                        System.out.println("Se han añadido " + grams + " gramos de " + newFood.getName() + " a la dieta '" + activeDiet + "'");
//                    } catch (MaxValuedReachedException e) {
//                        // Excepciones si se alcanzan los valores máximos permitidos
//                        System.out.println("No se pudo añadir el alimento debido a restricciones de dieta.");
//                    }

                    break;
                case 2:
                    if (foodList.isEmpty()) {
                        System.out.println("Para agregar un alimento existente, tienen que existir alimentos previos");
                        return;
                    }
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("@    Escoja un alimento     @");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    Integer i = 1;
                    for (Food food : foodList) {
                        System.out.println(i + "-" + food.getName());
                        i++;
                    }
                    System.out.println(i + "-Cancelar");
                    Integer element = Kb.getOption(1, i);
                    if (element == i) {
                        System.out.println("Cancelando alimento");
                        return;
                    }
                    Food storedFood = foodList.get(element - 1);
                    System.out.println("Indique el número de gramos de " + storedFood.getName());
                    Integer foodGrams = Kb.forceNextInt();
                    validateAndAddFoodToDiet(storedFood, foodGrams);
                    break;
                case 3:
                    break;
            }
        } while (option != 3);

    }
    private void modifyDiet(){
        //TODO Programar todo el método
        //TODO ~~~~~~~~~~~~~~~~~~~~~~~~
        //TODO ~~~~~~~~~~~~~~~~~~~~~~~~
        //TODO Programar todo el método
        System.out.println("1-Cambiar Calorías máximas");
        System.out.println("2-Cambiar Carbohidratos máximos");
        System.out.println("3-Cambiar Grasa máximas");
        System.out.println("4-Cambiar Proteinas máximas");
    }
    private void deleteDiet(){
        String youSure = Kb.nextLine("¿Está seguro de que desea eliminar la dieta " + activeDiet + " ? S/N");
        if (youSure.equals("S")) {
            dietsList.remove(activeDiet);
            System.out.println("Dieta " + activeDiet + " eliminada con éxito.\n");
            activeDiet = null;
        } else System.out.println("Menos mal que te pregunté, casi la lias.\n");
    }
    private void validateAndAddFoodToDiet(Food food, Integer grams){
        Diet diet = dietsList.get(activeDiet);
        try{
            diet.addFood(food,grams);
        }catch (MaxCaloriesReachedException ecal){
            System.out.println("Se ha alcanzado el máximo valor de calorías permitido");
        }catch (MaxCarbsReachedException ecar){
            System.out.println("Se ha alcanzado el máximo valor de carbohidratos permitido");
        }catch (MaxFatsReachedException efat){
            System.out.println("Se ha alcanzado el máximo valor de grasas permitido");
        }catch (MaxProteinsReachedException epro){
            System.out.println("Se ha alcanzado el máximo valor de proteínas permitido");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void clientsMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@      Clientes     @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@");
        if (activeClient != null){
            System.out.println("Cliente activo '" + activeClient + "'");
        } else System.out.println("No hay cliente activo.");
        System.out.println("Escriba una opción:");
        System.out.println("=====================");
        System.out.println("1-Lista de clientes");
        System.out.println("2-Buscar por nombre");
        System.out.println("3-Nuevo cliente");
        System.out.println("4-Cliente activo");
        System.out.println("5-Volver");
        System.out.println("=====================");
        Integer option = Kb.getOption(1,5);
        switch (option){
            case 1:
                selectClient();
                break;
            case 2:
                searchClient();
                break;
            case 3:
                newClient();
                break;
            case 4:
                if (activeClient == null){
                    System.out.println("Primero debe seleccionar un cliente.");
                } else activeClientMenu();
                break;
            case 5:
                break;
        }
    }
    public void selectClient() {
        int i;
        int tempList;

        // Recorremos lista de clientes y los mostramos
        if (clientsList.isEmpty()) {
            System.out.println("No se encontraron clientes en la base de datos.");
        } else {
            System.out.println("Lista de clientes:");
            for (i = 0; i < clientsList.size(); i++) {
                tempList = i + 1;
                System.out.println(tempList + ". " + clientsList.get(i));
            }

            // Se elige el cliente
            System.out.println("Escribe el número del cliente:");
            System.out.println("==============================");
            Integer client = Kb.getOption(1, i);
            client = client - 1;
            activeClient = clientsList.get(client);
            System.out.println("==============================");
            System.out.println("Ha elegido a: " + activeClient.getClientName() + " " + activeClient.getClientSurname() + "\n");

            activeClientMenu();
        }
    }
    private void searchClient(){
        int i;
        String searchName = Kb.nextLine("Escribe el nombre y apellidos del cliente:");
        List<Client> matchingClients = new ArrayList<>();

        // Iteramos a través de la lista de clientes y comparamos el nombre y apellidos.
        for (Client client : clientsList) {
            String fullName = client.getClientName() + " " + client.getClientSurname();
            if (fullName.equalsIgnoreCase(searchName)) {
                matchingClients.add(client);
            }
        }

        if (matchingClients.isEmpty()) {
            System.out.println("No se encontraron clientes que coincidan con la búsqueda.");
        } else {
            System.out.println("Clientes encontrados:");
            for (i = 0; i < matchingClients.size(); i++) {
                System.out.println((i + 1) + ". " + matchingClients.get(i).getClientName() + " " + matchingClients.get(i).getClientSurname());
            }
            System.out.println("Escribe el número del cliente:");
            System.out.println("==============================");
            int selectedClientIndex = Kb.getOption(1, matchingClients.size()) - 1;
            activeClient = matchingClients.get(selectedClientIndex);
            System.out.println("==============================");
            System.out.println("Ha seleccionado a: " + activeClient.getClientName() + " " + activeClient.getClientSurname());

            activeClientMenu();
        }
    }
    private void newClient() {
        String clientName = Kb.nextLine("Escribe el nombre del nuevo cliente:");
        String clientSurname = Kb.nextLine("Escribe los apellidos del nuevo cliente:");
        Integer clientWeight = Kb.forceNextInt("Peso del cliente en kg:");
        Integer clientHeight = Kb.forceNextInt("Altura del cliente en cm:");
        Integer clientAge = Kb.forceNextInt("Edad del cliente:");
        String  clientGender = Kb.nextLine("Hombre o mujer (H/M):");
        Client clientData = new Client(clientName, clientSurname, clientWeight, clientHeight, clientAge, clientGender);
        clientsList.add(clientData);
        System.out.println("Cliente " + clientName + " " + clientSurname + " añadido con éxito\n");
        activeClient = clientData;

        activeClientMenu();
    }
    private void activeClientMenu() {
        // Se muestra el menu para el cliente elegido
        System.out.println("@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@      Cliente      @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(activeClient.getClientName() + " " + activeClient.getClientSurname());
        System.out.println("=====================");
        System.out.println("1-Detalles de cliente");
        System.out.println("2-Asignar dieta");
        System.out.println("3-Dar de baja cliente");
        System.out.println("4-Volver");
        System.out.println("=====================");
        Integer option = Kb.getOption(1, 4);
        switch (option) {
            case 1:
                activeClient.showClientDetails();
                break;
            case 2:
                asignClientDiet();
                break;
            case 3:
                deleteClient();
                break;
            case 4:
                break;
        }
    }
    private void asignClientDiet() {
        //TODO Programar todo el método
        //TODO ~~~~~~~~~~~~~~~~~~~~~~~~
        //TODO ~~~~~~~~~~~~~~~~~~~~~~~~
        //TODO Programar todo el método
    }
    private void deleteClient(){
            String youSure = Kb.nextLine("¿Está seguro de que desea eliminar el cliente " + activeClient + " ? S/N");
            if (youSure.equals("S")) {
                clientsList.remove(activeClient);
                System.out.println("Cliente " + activeClient + " eliminado con éxito.\n");
                activeClient = null;
            } else System.out.println("Menos mal que te pregunté, casi la lias.\n");
    }
}