package com.example.f21comp1011assignment1.Models;


public class Product {
    private String name;
    private float protein, carbs, fat, ash, energy;

    public Product(String name, float protein, float carbs, float fat, float ash, float energy) {
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

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getAsh() {
        return ash;
    }

    public void setAsh(float ash) {
        this.ash = ash;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }
}
