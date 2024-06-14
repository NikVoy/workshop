package com.company.oop.cosmetics.core.contracts;

import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.contracts.ShoppingCart;

import java.util.List;

public interface CosmeticsRepository {

    ShoppingCart getShoppingCart();

    List<Category> getCategories();

    List<Product> getProducts();

    Product findProductByName(String productName);

    Category findCategoryByName(String categoryName);

    Category createCategory(String name);

    Product createProduct(String name, String brand, double price, String gender);

    boolean categoryExist(String categoryName);

    boolean productExist(String productName);

    void removeProductFromCart(Product product);

    void addProductToShoppingCart(Product product);

}
