package ru.netology;

public class Main {
    public static void main(String[] args) {

        Product book = new Book(
                1,
                "The Shadow of Chernobil",
                1500,
                "Какой-то чел"
        );

        // book.use();

        Product smartphone = new Smartphone(
                2,
                "XPeria Ray",
                18_000,
                "SonyEricsson"
        );

        // smartphone.use();
    }
}