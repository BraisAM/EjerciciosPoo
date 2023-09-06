package com.campusdual.ejercicio4;


import java.util.HashMap;
import java.util.Map;

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
	-getTotalProtein(): devuelve el total de proteinas
*/
public class Diet {
    String food;
    Map<Food, Integer> foodList = new HashMap<Food, Integer>();
    Integer maxCalories;
    Integer maxFats;
    Integer maxCarbs;
    Integer maxProtein;
    Boolean women;
    Integer age;
    Integer height;
    Integer weight;

    public Diet() {

    }
    public Diet(Integer maxCalories) {
        this.maxCalories = maxCalories;
    }

    public Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein) {
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProtein = maxProtein;
    }

    public Diet(Boolean women, Integer age, Integer height, Integer weight) {
        this.women = women;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void addFood(Food food, Integer grams){
        this.foodList.put(food,grams);
    }
    public Integer getTotalCalories() {
        this.foodList.put(new Food(10,4,5,"Manzana"),150);
        this.foodList.put(new Food(8,6,10,"Tofu"),200);
        this.foodList.put(new Food(7,4,4,"Pera"),150);
        System.out.println(this.foodList.keySet());
        for (int i = 0; i < this.foodList.size(); i++) {

        }
        return 1;
    }


}
