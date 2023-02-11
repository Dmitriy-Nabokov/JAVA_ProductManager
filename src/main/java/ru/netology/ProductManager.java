package ru.netology;

public class ProductManager {
    private ProductRepository repository;

    public void add(Product product) {                  // Добавляет товар в репозиторий

        repository.add(product);
    }

    public ProductManager(ProductRepository repository) {     // Осуществляет поиск товаров

        this.repository = repository;
    }

    public Product[] searchBy(String text) {            // тут будем хранить подошедшие запросу продукты
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // return product.getName().contains(search);
    }
}
