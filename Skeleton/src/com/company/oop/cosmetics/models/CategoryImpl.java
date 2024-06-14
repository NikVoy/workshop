package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {

    private String name;
    private List<Product> products;

    public CategoryImpl(String name) {
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl class.");
    }

    @Override
    public String getName() { throw new UnsupportedOperationException("Not implemented yet. CategoryImpl class."); }

    @Override
    public List<Product> getProducts() {
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl class.");
    }

    @Override
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl class.");
    }

    @Override
    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl class.");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl class.");
    }
}
