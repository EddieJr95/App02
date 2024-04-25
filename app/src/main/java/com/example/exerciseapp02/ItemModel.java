package com.example.exerciseapp02;

public class ItemModel {
    private String name;
    private int imageResId;

    public ItemModel(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}