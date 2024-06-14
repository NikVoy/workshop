package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.CosmeticsRepositoryImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.company.oop.cosmetics.tests.models.ProductTests.*;

public class CosmeticsRepositoryTests {

    CosmeticsRepositoryImpl cosmeticsRepository;

    @BeforeEach
    public void beforeEach() {
        cosmeticsRepository = new CosmeticsRepositoryImpl();
    }

    @Test
    public void createProduct_Should_CreateProduct_When_ArgsAreValid() {

        // Arrange, Act
        Product product = initializeTestProduct();

        // Act, Assert
        Assertions.assertEquals(
                product.getClass(),
                cosmeticsRepository.createProduct(
                        VALID_PRODUCT_NAME,
                        VALID_PRODUCT_BRAND,
                        10,
                        "MEN").getClass());
    }

    @Test
    public void findProductByName_Should_ReturnProduct_When_ProductIsFound() {

        // Arrange, Act
        Product product = cosmeticsRepository.createProduct(
                VALID_PRODUCT_NAME,
                VALID_PRODUCT_BRAND,
                10,
                "MEN");

        // Act, Assert
        Assertions.assertEquals(product, cosmeticsRepository.findProductByName(product.getName()));
    }

    @Test
    public void findProductByName_Should_ThrowException_When_ProductNotFound() {

        // Arrange, Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> cosmeticsRepository.findProductByName(VALID_PRODUCT_NAME));
    }
}
