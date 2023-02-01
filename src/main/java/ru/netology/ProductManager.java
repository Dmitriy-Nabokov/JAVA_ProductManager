package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public void add(Product product) {                  // Добавляет товар в репозиторий
        repo.save(product);
    }

    public ProductManager(ProductRepository repo) {     // Осуществляет поиск товаров
        this.repo = repo;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: ProductRepository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
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
