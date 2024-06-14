package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;

public class ProductImpl implements Product {
    //use constants for validations values

    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        throw new UnsupportedOperationException("Not implemented yet. ProductImpl class");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet. ProductImpl class");
    }

    @Override
    public String getBrandName() {
        throw new UnsupportedOperationException("Not implemented yet. ProductImpl class");
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException("Not implemented yet. ProductImpl class");
    }

    @Override
    public GenderType getGenderType() {
        throw new UnsupportedOperationException("Not implemented yet. ProductImpl class");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. ProductImpl class");
    }
}
