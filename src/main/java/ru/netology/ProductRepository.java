package ru.netology;

public class ProductRepository {

    private Product[] products = new Product[0];                // Массив товаров

    public void add(Product product) {                         // Сохраняем товары
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {                                 // Получаем сохраненные товары

        return products;
    }

    public void removeById(int removeId) {                       // Удаляем товар по ID
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product item : products) {
            if (item.getId() != removeId) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
