package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.ShoppingCart;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    public static final String CANNOT_ADD_PRODUCT_WHICH_IS_NULL = "Cannot add product which is null!";
    public static final String CANNOT_CONTAINS_PRODUCT_WHICH_IS_NULL = "Cannot contains product which is null!";
    public static final String CANNOT_REMOVE_PRODUCT_WHICH_IS_NULL = "Cannot remove product which is null!";
    private final List<Product> productList;

    public ShoppingCartImpl() {
        this.productList = new ArrayList<>();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(this.productList);
    }

    @Override
    public void addProduct(Product product) {
        ValidationHelpers.validateIsInputNull(product);
        this.productList.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        ValidationHelpers.validateIsInputNull(product);
        this.productList.remove(product);
    }

    @Override
    public boolean containsProduct(Product product) {
        ValidationHelpers.validateIsInputNull(product);
        return this.productList.contains(product);
    }

    @Override
    public double totalPrice() {
        double totalPrice = 0;

        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

}
