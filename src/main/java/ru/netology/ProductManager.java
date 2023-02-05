package ru.netology;

public class ProductManager {
    private static ProductRepository repo;

    public void add(Product product) {                  // Добавляет товар в репозиторий

        repo.save(product);
    }

    public ProductManager(ProductRepository repo) {     // Осуществляет поиск товаров

        this.repo = repo;
    }

    public Product[] searchBy(String text) {            // тут будем хранить подошедшие запросу продукты
        Product[] result = new Product[0];
        for (Product product: repo.findAll()) {
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
    }
}
