package com.example.f21comp1011assignment1.Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
    private final SimpleStringProperty name;
    private final SimpleFloatProperty protein, carbs, fat, ash, energy;

    public Product(String name, float protein, float carbs, float fat, float ash, float energy) {
        this.name = new SimpleStringProperty(name);
        this.protein =  new SimpleFloatProperty(protein);
        this.carbs =  new SimpleFloatProperty(carbs);
        this.fat =  new SimpleFloatProperty(fat);
        this.ash =  new SimpleFloatProperty(ash);
        this.energy =  new SimpleFloatProperty(energy);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public float getProtein() {
        return protein.get();
    }

    public void setProtein(float protein) {
        this.protein.set(protein);
    }

    public float getCarbs() {
        return carbs.get();
    }

    public void setCarbs(float carbs) {
        this.carbs.set(carbs);
    }

    public float getFat() {
        return fat.get();
    }

    public void setFat(float fat) {
        this.fat.set(fat);
    }

    public float getAsh() {
        return ash.get();
    }

    public void setAsh(float ash) {
        this.ash.set(ash);
    }

    public float getEnergy() {
        return energy.get();
    }

    public void setEnergy(float energy) {
        this.energy.set(energy);
    }
}
