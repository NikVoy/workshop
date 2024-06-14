package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.models.ShoppingCartImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import static com.company.oop.cosmetics.tests.models.ProductTests.initializeTestProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTests {

    ShoppingCartImpl shoppingCart;

    @BeforeEach
    public void beforeEach() {
        shoppingCart = new ShoppingCartImpl();
    }

    @Test
    public void constructor_Should_InitializeNewListOfProducts_When_CategoryIsCreated() {
        // Arrange, Act and Assert

        Assertions.assertNotNull(shoppingCart.getProducts());
    }

    @Test
    public void addProduct_Should_ThrowException_When_TheProductIsNull() {
        // Arrange, Act and Assert

        Assertions.assertThrows(IllegalArgumentException.class, () -> shoppingCart.addProduct(null));
    }

    @Test
    public void addProduct_Should_AddProduct_When_ProductIsValid() {
        // Arrange, Act
        Product productToAdd = initializeTestProduct();

        // Act
        shoppingCart.addProduct(productToAdd);
        shoppingCart.addProduct(productToAdd);

        //Assert
        Assertions.assertEquals(2, shoppingCart.getProducts().size());
    }

    @Test
    public void containsProduct_Should_ThrowException_When_TheProductIsNull() {
        // Arrange, Act and Assert

        Assertions.assertThrows(IllegalArgumentException.class, () -> shoppingCart.containsProduct(null));
    }

    @Test
    public void containsProduct_Should_ReturnTrue_When_ProductIsFound() {
        // Arrange, Act
        Product productToAdd = initializeTestProduct();
        shoppingCart.addProduct(productToAdd);
        shoppingCart.addProduct(productToAdd);

        // Act
        boolean isFound = shoppingCart.containsProduct(productToAdd);

        //Assert
        Assertions.assertTrue(isFound);
    }

    @Test
    public void containsProduct_Should_ReturnFalse_When_ProductNotFound() {
        // Arrange, Act
        Product productToAdd = initializeTestProduct();

        // Act
        boolean isFound = shoppingCart.containsProduct(productToAdd);

        //Assert
        Assertions.assertFalse(isFound);
    }

    @Test
    public void removeProduct_Should_ThrowException_When_TheProductIsNull() {
        // Arrange, Act and Assert

        Assertions.assertThrows(IllegalArgumentException.class, () -> shoppingCart.removeProduct(null));
    }

    @Test
    public void removeProduct_Should_RemoveProduct_When_ProductIsValid() {
        // Arrange, Act
        Product productToAdd = initializeTestProduct();

        shoppingCart.addProduct(productToAdd);
        shoppingCart.addProduct(productToAdd);

        // Act
        shoppingCart.removeProduct(productToAdd);

        //Assert
        Assertions.assertEquals(1, shoppingCart.getProducts().size());
    }
}
