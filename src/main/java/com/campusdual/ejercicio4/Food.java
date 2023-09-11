package com.campusdual.ejercicio4;

public class Food {
    protected Integer carbs;
    protected Integer fats;
    protected Integer proteins;
    protected String foodName;

    public Food(){
        this.carbs=0;
        this.fats=0;
        this.proteins=0;
        this.foodName="";
    }

    public Food(Integer carbos,Integer fats, Integer proteins, String foodName){
        this.carbs=carbos;
        this.fats=fats;
        this.proteins=proteins;
        this.foodName=foodName;
    }
    public Integer getCalories(Integer weight){
        return(((carbs*4)+(fats*9)+(proteins*4))*weight/100);
    }
    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbos) {
        this.carbs = carbos;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}