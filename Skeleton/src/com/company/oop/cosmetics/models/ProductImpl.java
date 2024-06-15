package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ProductImpl implements Product {
    private static final int nameMinLength = 3;
    private static final int nameMaxLength = 10;
    private static final int brandMinLength = 2;
    private static final int brandMaxLength = 10;

    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
        this.setGender(gender);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, nameMinLength, nameMaxLength, "Product name");
        this.name = name;
    }

    @Override
    public String getBrandName() {
        return this.brand;
    }

    public void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, brandMinLength, brandMaxLength, "Product brand");
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public GenderType getGenderType() {
        return this.gender;
    }

    public void setGender(GenderType gender) {
        if (gender.equals(GenderType.MEN) || gender.equals(GenderType.WOMEN) || gender.equals(GenderType.UNISEX)) {
            this.gender = gender;
        }
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("#%s %s", this.name, this.brand)).append(System.lineSeparator()).append(String.format("#Price: %.2f", this.price)).append(System.lineSeparator()).append(String.format("#Gender: %s", this.gender));

        return result.toString();
    }
}
