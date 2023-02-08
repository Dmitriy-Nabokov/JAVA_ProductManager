package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Колобок", 400, "Константин Ушинский");
    Product product2 = new Smartphone(312, "XPeria Ray", 18_000, "SonyEricsson");
    Product product3 = new Book(41, "The Fellowship of the Ring", 4_000, "J.R.R.Tolkien");
    Product product4 = new Smartphone(544, "MI8", 20_000, "Xiaomi");
    Product product5 = new Book(5, "Возвращение колобка", 300, "Иванов И.И.");



    @BeforeEach
    public void add() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void addProduct() {      // Добавить в репозиторий

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
        public void shouldSearchProduct () {          // Осуществляем поиск по одному товару

        manager.matches(product1, "Колоб");

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Колоб");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchTwoProducts () {          // Осуществляем поиск по нескольким товарам

        manager.matches(product1, "олоб");
        manager.matches(product5, "олоб");

        Product[] expected = {product1, product5};
        Product[] actual = manager.searchBy("олоб");

        Assertions.assertArrayEquals(expected, actual);
    }



}