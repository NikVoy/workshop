package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final int CATEGORY_NAME_MIN_LENGTH = 2;
    private static final int CATEGORY_NAME_MAX_LENGTH = 15;
    public static final String CATEGORY_NAME = "Category name";
    public static final String CANNOT_ADD_PRODUCT_WHICH_IS_NULL = "Cannot add product which is null!";
    public static final String PRODUCT_IS_NOT_FOUND = "Product is not found!";

    private String name;
    private List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, CATEGORY_NAME_MIN_LENGTH, CATEGORY_NAME_MAX_LENGTH, CATEGORY_NAME);
        this.name = name;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(this.products);
    }

    @Override
    public void addProduct(Product product) {
        ValidationHelpers.validateIsInputNull(product);
        this.products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        if (!this.products.contains(product)) {
            throw new IllegalArgumentException(PRODUCT_IS_NOT_FOUND);
        }

        this.products.remove(product);
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("#Category: %s", this.name))
                .append(System.lineSeparator());

        List<Product> products = this.getProducts();

        if (products.isEmpty()) {
            result.append(" #No product in this category");
        } else {
            for (Product product : products) {
                result.append(String.format(" #%s %s", product.getName(), product.getBrandName()))
                        .append(System.lineSeparator())
                        .append(String.format(" #Price: $%.2f", product.getPrice()))
                        .append(System.lineSeparator())
                        .append(String.format(" #Gender: %s", product.getGenderType()))
                        .append(System.lineSeparator())
                        .append(" ===");
            }
        }

        return result.toString();
    }
}
