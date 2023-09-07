package com.campusdual.ejercicio4;


import java.util.ArrayList;
import java.util.List;

/*
Escribe una clase dieta, que teniendo en cuenta una serie de alimentos, vaya sumando cantidades en gramos y calcule cuantas calorías, carbohidratos, proteinas y grasas genera la ingesta
La clase dieta tiene que tener las siguientes funcionalidades:
	-Diet(): crea una dieta sin límite de calorías
	-Diet(Integer maxCalories): crea una dieta con un máximo de calorías, en cuanto se supera ese máximo cuando se adjunta un alimento se despliega un error
	-Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein): crea una dieta con un máximo de estos tres valores, si se supera alguno de ellos cuando se adjunta un alimento se indicara cual y desplegará un error
	-Diet(Boolean women, Integer age, Integer height, Integer weight): Calcula el metabolismo basal de la persona y lo asigna como máximo de calorías en la dieta
		--CALCULAR METABOLISMO BASAL
			E = edad
			A = altura en centímetros
			P = peso en kilos

			Fórmula Hombres: TMB = 10P + 6,25A – 5E + 5
			Fórmula Mujeres: TMB = 10P + 6,25A – 5E – 161
	-addFood(Food,Integer): agrega un alimento y una cantidad en gramos X
	-getTotalCalories(): devuelve el total de calorías
	-getTotalCarbs(): devuelve el total de carbohidratos
	-getTotalFats(): devuelve el total de grasas
	-getTotalProteins(): devuelve el total de proteinas
*/
public class Diet {
    /*
    public static class FoodWithWeight {
        private Food food;
        private Integer weight;

        public FoodWithWeight(Food food, Integer weight) {
            this.food = food;
            this.weight = weight;
        }
    }
    */
    //List<FoodWithWeight> listFood = new ArrayList<>();
    Integer maxCalories;
    Integer maxFats;
    Integer maxCarbs;
    Integer maxProtein;
    Boolean women;
    Integer age;
    Integer height;
    Integer weight;
    List<FoodWithWeight> listFood;


    public Diet() {
        listFood = new ArrayList<>();
    }
    public Diet(Integer maxCalories) {
        this.maxCalories = maxCalories;
        listFood = new ArrayList<>();
    }

    public Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein) {
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProtein = maxProtein;
        listFood = new ArrayList<>();
    }

    public Diet(Boolean women, Integer age, Integer height, Integer weight) {
        this.women = women;
        this.age = age;
        this.height = height;
        this.weight = weight;
        double maxCalories;
        //Fórmula Hombres: TMB = 10P + 6,25A – 5E + 5
        //Fórmula Mujeres: TMB = 10P + 6,25A – 5E – 161
        if (!women) {
            maxCalories = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        }
        else if (women){
            maxCalories = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
        listFood = new ArrayList<>();
    }

    public List<FoodWithWeight> getListFood() {
        return listFood;
    }

    public void setListFood(List<FoodWithWeight> listFood) {
        this.listFood = listFood;
    }

    public void addFood(Food food, Integer grams){
        if (maxCalories != null && maxCalories < (getTotalCalories() + food.getCalories(grams))){
            System.out.println("Ha superado el límite de calorias establecido.");
            return ;
        }
        FoodWithWeight newFood = new FoodWithWeight(food, grams);
        listFood.add(newFood);
    }
    public Integer getTotalCalories() {
        Integer result = 0;
        for (FoodWithWeight actualFood:
             listFood) {
            Food food = actualFood.getFood();
            Integer grams = actualFood.getGrams();
            Integer calories = food.getCalories(grams);
            result = result + calories;
        }
        return result;
    }
    public Integer getTotalCarbs() {
        return 1;
    }
    public Integer getTotalFats() {
        return 2;
    }
    public Integer getTotalProteins() {
        return 3;
    }
    public class FoodWithWeight{
        private Food food;
        private Integer grams;

        public FoodWithWeight(Food food, Integer grams) {
            this.food = food;
            this.grams = grams;
        }

        public Food getFood() {
            return food;
        }

        public void setFood(Food food) {
            this.food = food;
        }

        public Integer getGrams() {
            return grams;
        }

        public void setGrams(Integer grams) {
            this.grams = grams;
        }
    }
}
