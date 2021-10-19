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
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 3){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Minimum Length required");
        }
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getAsh() {
        return ash;
    }

    public void setAsh(double ash) {
        this.ash = ash;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }


    public void resetData(){
        setAsh(0);
        setEnergy(0);
        setFat(0);
        setCarbs(0);
    }
}
