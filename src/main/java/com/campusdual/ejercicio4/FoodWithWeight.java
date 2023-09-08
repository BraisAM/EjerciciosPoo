package com.campusdual.ejercicio4;

public class FoodWithWeight extends Food{
    private Integer grams;
    public static final Integer GRAMS_PER_PORTION = 100;
    public FoodWithWeight(Integer carbs,Integer fats,Integer proteins, String foodName, Integer grams) {
        super(carbs, fats, proteins, foodName);
        this.grams = grams;
    }
    public FoodWithWeight(Food food, Integer grams){
        super(food.carbs, food.fats, food.proteins, food.foodName);
        this.grams = grams;
    }
    public Integer calculatedCalories(){
        return this.getCalories(this.grams);
    }
    public Integer calculatedCarbs(){
        return this.getCarbs() * this.getGrams() / this.GRAMS_PER_PORTION;
    }
    public Integer calculatedFats(){
        return this.getFats() * this.getGrams() / this.GRAMS_PER_PORTION;
    }
    public Integer calculatedProteins(){
        return this.getProteins() * this.getGrams() / this.GRAMS_PER_PORTION;
    }
    public Integer getGrams() {
        return grams;
    }
    public void setGrams(Integer grams) {
        this.grams = grams;
    }
//    public Integer getCalories(){
//        //1 gramo de proteína nos da 4 calorías.
//        // 1 gramo de carbohidratos nos da 4 calorías.
//        // 1 gramo de grasa nos da 9 calorías
//        return(((this.carbs*4)+(fats*9)+(proteins*4))*grams/100);
//    }

//    public void setFood(Food food) {
//        this.food = food;
//    }

}
