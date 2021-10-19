package com.example.f21comp1011assignment1.Models;


public class Product {
    private String name;
    private int id;
    private double protein, carbs, fat, ash, energy;



    public Product(int id, String name, double protein, double carbs, double fat, double ash, double energy) {
        setId(id);
        setName(name);
        setProtein(protein);
        setCarbs(carbs);
        setFat(fat);
        setAsh(ash);
        setEnergy(energy);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("Id must be a positive number");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 3){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Minimum Length required is 4");
        }
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        if(protein >= 0){
            this.protein = protein;
        }
        else{
            throw new IllegalArgumentException("Protein value can't be a negative number");
        }
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        if(carbs >= 0){
            this.carbs = carbs;
        }
        else{
            throw new IllegalArgumentException("Carbs value can't be a negative number");
        }
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        if(fat >= 0){
            this.fat = fat;
        }
        else{
            throw new IllegalArgumentException("Fat value can't be a negative number");
        }

    }

    public double getAsh() {
        return ash;
    }

    public void setAsh(double ash) {
        if(ash >= 0){
            this.ash = ash;
        }
        else{
            throw new IllegalArgumentException("Ash value can't be a negative number");
        }
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        if(energy >= 0){
            this.energy = energy;
        }
        else{
            throw new IllegalArgumentException("Energy value can't be a negative number");
        }

    }
}
