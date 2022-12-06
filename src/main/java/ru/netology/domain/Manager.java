package ru.netology.domain;

import ru.netology.Product;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product findById(int id) {
       return repo.findById(id);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                result = new Product[result.length + 1];
                result[result.length - 1] = product;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
