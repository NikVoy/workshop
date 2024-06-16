package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    private final List<Product> productList;

    public ShoppingCartImpl() {
        this.productList = new ArrayList<Product>();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(this.productList);
    }

    @Override
    public void addProduct(Product product) {
        if (product == null){
            throw new IllegalArgumentException("Cannot add product which is null!");
        }
        this.productList.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        if (product == null){
            throw new IllegalArgumentException("Cannot remove product which is null!");
        }
        this.productList.remove(product);
    }

    @Override
    public boolean containsProduct(Product product) {
        if (product == null){
            throw new IllegalArgumentException("Cannot contains product which is null!");
        }
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
