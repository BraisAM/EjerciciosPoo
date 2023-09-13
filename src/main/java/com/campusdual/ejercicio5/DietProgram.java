package com.campusdual.ejercicio5;

import com.campusdual.ejercicio5.exceptions.MaxCaloriesReachedException;
import com.campusdual.ejercicio5.exceptions.MaxCarbsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxFatsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxProteinsReachedException;

import java.util.ArrayList;
import java.util.List;

public class DietProgram {
    private Diet diet=null;
    private List<Food> foodList;
    private List<Client> clientsList;
    private List<Diet> dietsList;
    private Client activeClient;

    public DietProgram(){
        foodList = new ArrayList<>();
        clientsList = new ArrayList<>();
        dietsList = new ArrayList<>();
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public List<Diet> getDietsList() {
        return dietsList;
    }

    public void setDietsList(List<Diet> dietsList) {
        this.dietsList = dietsList;
    }

    public void showMenuProgram(){
        System.out.println("\n" +
                "█▀█ █▀█ █▀█ █▀▀ █▀█ ▄▀█ █▀▄▀█ ▄▀█   █▀▄ █▀▀   █▀▄ █ █▀▀ ▀█▀ ▄▀█ █▀\n" +
                "█▀▀ █▀▄ █▄█ █▄█ █▀▄ █▀█ █░▀░█ █▀█   █▄▀ ██▄   █▄▀ █ ██▄ ░█░ █▀█ ▄█");
        Integer option;
        do{
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
        System.out.println("Escriba una opción:");
        System.out.println("====================");
        System.out.println("1-Agregar dieta");
        System.out.println("2-Detalles de dieta");
        System.out.println("3-Eliminar dieta");
        System.out.println("4-Volver");
        System.out.println("====================");
        Integer option = Kb.getOption(1,4);
        switch (option){
            case 1:
                createDietMenu();
                break;
            case 2:
                showDietDetails();
                break;
            case 3:
                deleteDiet();
                break;
            case 4:
                break;
        }
    }
    private void clientsMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@       Clientes      @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("=====================");
        System.out.println("1-Lista de clientes");
        System.out.println("2-Buscar por nombre");
        System.out.println("3-Nuevo cliente");
        System.out.println("4-Volver");
        System.out.println("=====================");
        Integer option = Kb.getOption(1,4);
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
                break;
        }
    }
    private void addFoodMenu() {
        if(this.diet==null){
            System.out.println("Para agregar alimentos hace falta iniciar una dieta");
            return;
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@   Agregar alimentos a la dieta  @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Agregar un nuevo alimento");
        System.out.println("2-Agregar un alimento ya existente");
        System.out.println("===================================");

        Integer option = Kb.getOption(1,2);
        switch (option){
            case 1:
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@    Datos de nuevo alimento    @");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Nombre del alimento:");
                String name = Kb.nextLine();
                System.out.println("Carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Proteínas:");
                Integer proteins = Kb.forceNextInt();
                System.out.println("Gramos:");
                Integer grams = Kb.forceNextInt();
                Food newFood = new Food(name,carbs,fats,proteins);
                validateAndAddFoodToDiet(newFood,grams);
                foodList.add(newFood);
                break;
            case 2:
                if(foodList.size()==0){
                    System.out.println("Para agregar un alimento existente, tienen que existir alimentos previos");
                    return;
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@    Escoja un alimento     @");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                Integer i = 1;
                for(Food food:foodList){
                    System.out.println(i+"- "+food.getName());
                    i++;
                }
                System.out.println(i+"- Cancelar");
                Integer element = Kb.getOption(1,i);
                if(element==i){
                    System.out.println("Cancelando alimento");
                    return;
                }
                Food storedFood = foodList.get(element-1);
                System.out.println("indique el número de gramos de "+storedFood.getName());
                Integer foodGrams = Kb.forceNextInt();
                validateAndAddFoodToDiet(storedFood,foodGrams);
                break;
        }
    }

    private void validateAndAddFoodToDiet(Food food, Integer grams){
        try{
            this.diet.addFood(food,grams);
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

    private void createDietMenu() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@      Crear/reiniciar dieta      @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Dieta sin límite");
        System.out.println("2-Dieta por calorías");
        System.out.println("3-Dieta por macronutrientes");
        System.out.println("4-Dieta por datos personales");
        Integer option = Kb.getOption(1,4);
        switch (option){
            case 1:
                this.diet = new Diet();
                System.out.println("Se ha creado una dieta sin límites");
                break;
            case 2:
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@    Escriba número de calorias   @");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                Integer calories = Kb.forceNextInt();
                this.diet = new Diet(calories);
                System.out.println("Se ha creado una dieta con "+calories+" calorías máximas");
                break;
            case 3:
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@   Escriba los macronutrientes   @");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Proteínas:");
                Integer proteins = Kb.forceNextInt();
                this.diet = new Diet(fats,carbs,proteins);
                System.out.println("Se ha creado una dieta con Carbohidratos:"+carbs+", Grasas:"+fats+" ,Proteínas:"+proteins);
                break;
            case 4:
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@  Escriba los datos personales del cliente  @");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Peso:");
                Integer weight = Kb.forceNextInt();
                System.out.println("Altura:");
                Integer height = Kb.forceNextInt();
                System.out.println("Edad:");
                Integer age = Kb.forceNextInt();
                System.out.println("Mujer u Hombre(m/h):");
                String sexCharacter = Kb.nextLine();
                this.diet = new Diet("m".equalsIgnoreCase(sexCharacter),age,height,weight);
                System.out.println("Se ha creado una dieta de "+this.diet.getMaxCalories()+" calorías máximas");
                break;
        }
    }

    private void showDietDetails() {
        if(this.diet!=null){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@       Detalles de la dieta      @");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            if(this.diet.getMaxCalories()!=null){
                System.out.println("El número máximo de calorías es:"+this.diet.getMaxCalories());
            }
            if(this.diet.getMaxCarbs() != null || this.diet.getMaxFats() != null || this.diet.getMaxProteins() != null){
                System.out.println("Los valores máximos de macronutrientes son: Carbohidratos:"+this.diet.getMaxCarbs()+" , Grasas:"+this.diet.getMaxFats()+" , Proteinas:"+this.diet.getMaxProteins());
            }
            System.out.println("Número de alimentos de la dieta: "+this.diet.getFoodNumber());
            System.out.println("Calorías: "+this.diet.getTotalCalories());
            System.out.println("Carbohidratos: "+this.diet.getTotalCarbs());
            System.out.println("Grasas: "+this.diet.getTotalFats());
            System.out.println("Proteínas: "+this.diet.getTotalProteins());
            System.out.println("Alimentos de la dieta: "+this.diet.getDietIntakes());
        }else{
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@    La dieta no esta iniciada    @");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }
    public void selectClient() {
        int i;
        Integer tempList;
        String clientName;

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
    private void newClient(){
        String clientName = Kb.nextLine("Escribe el nombre del nuevo cliente:");
        String clientSurname = Kb.nextLine("Escribe los apellidos del nuevo cliente:");
        Integer clientWeight = Kb.forceNextInt("Peso del cliente en kg:");
        Integer clientHeight = Kb.forceNextInt("Altura del cliente en cm:");
        Integer clientAge = Kb.forceNextInt("Edad del cliente:");
        String clientGender = Kb.nextLine("Hombre o mujer (H/M):");
        Client clientData = new Client(clientName, clientSurname, clientWeight, clientHeight, clientAge, clientGender);
        clientsList.add(clientData);
        System.out.println("Cliente " + clientName + " " + clientSurname + " añadido con éxito\n");
        activeClient = clientData;

        activeClientMenu();
    }
    private void deleteDiet(){

    }
    private void asignClientDiet(){

    }
    private void deleteClient(){
        clientsList.remove(activeClient);
        System.out.println("Cliente eliminado con éxito.");
    }
}