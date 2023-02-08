package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Book(1, "Колобок", 400, "Константин Ушинский");
    Product product2 = new Smartphone(312, "XPeria Ray", 18_000, "SonyEricsson");
    Product product3 = new Book(41, "The fellowship of the Ring", 4_000, "J.R.R.Tolkien");
    Product product4 = new Smartphone(544, "MI8", 20_000, "Xiaomi");

    @Test
    public void saveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByID() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(product2.getId());
        repo.removeById(product3.getId());

        Product[] expected = {product1, product4};
        Product[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }
}
