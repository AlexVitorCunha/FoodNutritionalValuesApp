package com.example.f21comp1011assignment1.Models;


public class Product {
    private String name;
    private double protein, carbs, fat, ash, energy;

    public Product() {
        setProtein(0);
        setEnergy(0);
        setFat(0);
        setAsh(0);
    }

    public Product(String name, double protein, double carbs, double fat, double ash, double energy) {
        setName(name);
        setProtein(protein);
        setCarbs(carbs);
        setFat(fat);
        setAsh(ash);
        setEnergy(energy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
