# OOP Workshop - Cosmetics Shop 1

## Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work easier.

## Description

You are given a software system for managing a cosmetics shop. There are three models - `Product`, `Category` and `Shopping cart`. Your task is to design an object-oriented class hierarchy to model the cosmetics shop, using the best practices for object-oriented design (OOD) and object-oriented programming (OOP). Encapsulate all fields correctly and use validation whenever needed.

## Architecture

A working `Engine` already executes a sequence of commands read from the console. It uses the classes and interfaces in your project (see the `CosmeticsEngineImpl` class). You do not have to touch anything in it or the `main()` method, but you could try to understand how they work. All models needed are already in the  **cosmetics.models** package.

## Models

> Note: All validation intervals are inclusive (closed).

> Note: Check the `ValidationHelpers` class in **cosmetics.utils** package.

### **ProductImpl**

- Each `product` in the system has a `name, brand, price, and gender`.
- `name` - the name's length should be between `3` and `10` symbols.
- `brand` - the brand name's length should be between `2` and `10` symbols.
- `price` cannot be negative.
- `Gender type` can be `[Men, Women or Unisex]`.
- Product's `print()` method should return text in the following format:

```none
 #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
```

### **CategoryImpl**

- Each `category` has a `name` and a list of `products` in which we can **add** or **remove**.
- `name` - the category name's length should be between `2` and `15` symbols.
- Adding the same `product` to one `category` more than once is allowed.
- When removing a `product` from a `category`, you should throw an `exception` if the product is not found.

> Note: We have yet to talk about exceptions, but all you need to know for now is that they indicate if something goes wrong. If you write `throw new IllegalArgumentException()`, you are **throwing an exception**.

- Category's `print()` method should return text in the following format:

```none
#Category: {category name}
 #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 ===
 #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 ===
```

```none
#Category: Shampoos
 #No product in this category
```

### **ShoppingCartImpl**

- `Products` can be **added** to or **removed** from a `shopping cart`.
- Adding the same product more than once is allowed.
- No need to check if the product exists when removing it from the `shopping cart`.
- The `shopping cart` can calculate the `total price` of all the `products` in it.

## Repository

The `CosmeticsRepositoryImpl` class is used to store and retrieve all the information that the application needs. It also contains the `create()` methods of the objects. Your task is to implement all methods that throw `UnsupportedOperationException`. 

## Constraints

- Check the example below to understand the printing format better.
- Format all floating-point values with **two digits** after the decimal point.

## Unit Tests

- You are given unit tests to keep track of your progress.
- Run them by right-clicking the **tests** package and selecting **Run 'All Tests'**.
- If you get stuck, check out the tests' names to guide you on what to do.

> Note: Be careful not to change anything in the **tests** folder.

## Step by step guide

1. Start with the `Product` class

	- Encapsulate all the fields.

2. Have a look at the `CosmeticsRepositoryImpl` class in the **cosmetics.core** package

	- Implement the `createProduct()` method. Look at the other methods for ideas.

		> Note: Parse string to enum: [How to parse](https://stackoverflow.com/questions/7056959/convert-string-to-equivalent-enum-value)

	- Implement the `findProductByName()` method. Look at the other methods for ideas.

3. Finish the `ShoppingCart` class

	- Initialize the collection.

		```
		public ShoppingCart() {
		    productList = new ArrayList<Product>();
		}
		```

	- The other methods are just manipulating the collection.

	- Encapsulate it (don't allow direct access to it).

4. Finish the `Category` class

	- Encapsulate all the fields (don't allow direct access to its collection).

	- Initialize the collection.

	- The other methods are just manipulating the collection.

5. Implement `print()` methods in both the `Category` and `Product` classes

	- To test the `print()` method, you must run the application, pass the sample input and check the output.

### Sample Input

```
CreateProduct MyMan Nivea 10.99 Men
CreateCategory Shampoos
AddToCategory Shampoos MyMan
AddToShoppingCart MyMan
ShowCategory Shampoos
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Sample Output

```
Product with name MyMan was created!
Category with name Shampoos was created!
Product MyMan added to category Shampoos!
Product MyMan was added to the shopping cart!
#Category: Shampoos
 #MyMan Nivea
 #Price: $10.99
 #Gender: MEN
 ===
$10.99 total price currently in the shopping cart!
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
No product in shopping cart!
```
