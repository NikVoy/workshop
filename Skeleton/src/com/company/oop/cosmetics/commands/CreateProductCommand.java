package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateProductCommand implements Command {

    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    private static final String PRODUCT_ALREADY_EXIST = "Product with name %s already exists!";
    private static final String INVALID_PRICE = "Invalid value for price. Should be a number.";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;

    private final CosmeticsRepository repository;

    public CreateProductCommand(CosmeticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), INVALID_PRICE);
        String gender = parameters.get(3);
        return createProduct(name, brand, price, gender);
    }

    private String createProduct(String name, String brand, double price, String gender) {
        if (repository.productExist(name)) {
            throw new IllegalArgumentException(String.format(PRODUCT_ALREADY_EXIST, name));
        }

        repository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

}
