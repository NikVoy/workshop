package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.ShoppingCart;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    private final List<Product> productList;

    public ShoppingCartImpl() {
        throw new UnsupportedOperationException("Not implemented yet. ShoppingCartImpl class.");
    }

    @Override
    public List<Product> getProducts() {
        throw new UnsupportedOperationException("Not implemented yet. ShoppingCartImpl class.");
    }

    @Override
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet. ShoppingCartImpl class.");
    }

    @Override
    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet. ShoppingCartImpl class.");
    }

    @Override
    public boolean containsProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet. ShoppingCartImpl class.");
    }

    @Override
    public double totalPrice() {
        throw new UnsupportedOperationException("Not implemented yet. ShoppingCartImpl class.");
    }

}
