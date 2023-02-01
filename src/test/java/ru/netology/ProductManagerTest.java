package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product product1 = new Book(1, "Колобок", 400, "Константин Ушинский");
    Product product2 = new Smartphone(312, "XPeria Ray", 18000, "SonyEricsson");
    Product product3 = new Book(41, "The Fellowship of the Ring", 4_000, "J.R.R.Tolkien");
    Product product4 = new Smartphone(544, "MI8", 20000, "Xiaomi");

    @Test
    public void addProduct() {                                             // Добавить в репозиторий

        ProductManager repo = new ProductManager();  /// Какую переменную здесь требуется указать? !!!

        Product[] products = {product1, product2, product3};

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = ProductManager.add(product4);    /// Непонятно почему функция не работает

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProduct() {  // Осуществляем поиск
        ProductManager repo = new ProductManager();  /// Какую переменную здесь требуется указать? !!!

        Product[] products = {product1, product2, product3, product4};

        Product[] expected = {product1};
        Product[] actual = ProductManager.searchBy("Колобок");     /// Непонятно почему функция не работает

        Assertions.assertArrayEquals(expected, actual);

    }
}