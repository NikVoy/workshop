package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import static com.company.oop.cosmetics.tests.utils.TestUtilities.getString;
import static com.company.oop.cosmetics.tests.models.ProductTests.initializeTestProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTests {

    public static final int CATEGORY_NAME_MIN_LENGTH = 2;
    public static final int CATEGORY_NAME_MAX_LENGTH = 15;
    public static final String VALID_CATEGORY_NAME = getString(CATEGORY_NAME_MIN_LENGTH + 1);
    public static final String SHORT_INVALID_CATEGORY_NAME = getString(CATEGORY_NAME_MIN_LENGTH - 1);
    public static final String LONG_INVALID_CATEGORY_NAME = getString(CATEGORY_NAME_MAX_LENGTH + 1);

    @Test
    public void addProduct_Should_ThrowException_When_TheProductIsNull() {
        // Arrange, Act
        Category category = initializeTestCategory();

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> category.addProduct(null));
    }

    @Test
    public void addProduct_Should_AddProduct_When_ProductIsValid() {
        // Arrange
        Category category = initializeTestCategory();
        Product productToAdd = initializeTestProduct();

        // Act
        category.addProduct(productToAdd);
        category.addProduct(productToAdd);

        //Assert
        Assertions.assertEquals(2, category.getProducts().size());
    }

    @Test
    public void constructor_Should_ThrowException_When_TheNameIsShorterThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CategoryImpl(SHORT_INVALID_CATEGORY_NAME));
    }

    @Test
    public void constructor_Should_ThrowException_When_TheNameIsLongerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CategoryImpl(LONG_INVALID_CATEGORY_NAME));
    }

    @Test
    public void constructor_Should_CreateCategory_When_NameIsValid() {
        // Arrange, Act and Assert
        Assertions.assertDoesNotThrow(() -> new CategoryImpl(VALID_CATEGORY_NAME));
    }

    @Test
    public void constructor_Should_InitializeNewListOfProducts_When_CategoryIsCreated() {
        // Arrange, Act

        Category category = initializeTestCategory();

        // Assert
        Assertions.assertNotNull(category.getProducts());
    }

    @Test
    public void removeProduct_Should_ThrowException_When_TheProductIsNull() {
        // Arrange, Act
        Category category = initializeTestCategory();

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> category.removeProduct(null));
    }

    @Test
    public void removeProduct_Should_RemoveProduct_When_ProductIsValid() {
        // Arrange, Act
        Category category = initializeTestCategory();
        Product productToRemove = initializeTestProduct();
        category.addProduct(productToRemove);
        category.addProduct(productToRemove);

        // Act
        category.removeProduct(productToRemove);

        //Assert
        Assertions.assertEquals(1, category.getProducts().size());
    }

    @Test
    public void removeProduct_Should_ThrowException_When_ProductNotFound() {
        // Arrange, Act
        Category category = initializeTestCategory();
        Product productToRemove = initializeTestProduct();

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> category.removeProduct(productToRemove));
    }

    public static CategoryImpl initializeTestCategory() {
        return new CategoryImpl(VALID_CATEGORY_NAME);
    }
}
