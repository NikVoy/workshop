package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.enums.GenderType;
import static com.company.oop.cosmetics.tests.utils.TestUtilities.getString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTests {
    public static final int PRODUCT_NAME_MIN_LENGTH = 2;
    public static final int PRODUCT_NAME_MAX_LENGTH = 10;
    public static final int PRODUCT_BRAND_MIN_LENGTH = 2;
    public static final int PRODUCT_BRAND_MAX_LENGTH = 10;
    public static final String VALID_PRODUCT_NAME = getString(PRODUCT_NAME_MIN_LENGTH + 1);
    public static final String VALID_PRODUCT_BRAND = getString(PRODUCT_BRAND_MIN_LENGTH + 1);
    public static final String SHORT_INVALID_PRODUCT_NAME = getString(PRODUCT_NAME_MIN_LENGTH - 1);
    public static final String LONG_INVALID_PRODUCT_NAME = getString(PRODUCT_NAME_MAX_LENGTH + 1);
    public static final String SHORT_INVALID_PRODUCT_BRAND = getString(PRODUCT_BRAND_MIN_LENGTH - 1);
    public static final String LONG_INVALID_PRODUCT_BRAND = getString(PRODUCT_BRAND_MAX_LENGTH + 1);

    @Test
    public void constructor_Should_ThrowException_When_TheNameIsShorterThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductImpl(
                        SHORT_INVALID_PRODUCT_NAME,
                        VALID_PRODUCT_BRAND,
                        10,
                        GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_TheNameIsLongerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductImpl(
                        LONG_INVALID_PRODUCT_NAME,
                        VALID_PRODUCT_BRAND,
                        10,
                        GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_TheBrandIsShorterThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductImpl(
                        VALID_PRODUCT_NAME,
                        SHORT_INVALID_PRODUCT_BRAND,
                        10,
                        GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_TheBrandIsLongerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductImpl(
                        VALID_PRODUCT_NAME,
                        LONG_INVALID_PRODUCT_BRAND,
                        10,
                        GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_PriceIsNegative() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductImpl(
                        VALID_PRODUCT_NAME,
                        VALID_PRODUCT_BRAND,
                        -1,
                        GenderType.MEN));
    }

    @Test
    public void constructor_Should_CreateProduct_When_ValidValuesArePassed() {
        // Arrange, Act and Assert
        Assertions.assertDoesNotThrow(() ->
                new ProductImpl(
                        VALID_PRODUCT_NAME,
                        VALID_PRODUCT_BRAND,
                        10,
                        GenderType.MEN));
    }

    public static ProductImpl initializeTestProduct() {
        return new ProductImpl(
                VALID_PRODUCT_NAME,
                VALID_PRODUCT_BRAND,
                10,
                GenderType.MEN);
    }
}
