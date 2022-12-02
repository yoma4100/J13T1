package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.Smartphone;

public class RepositoryTest {
    Repository repo = new Repository();
    Product product1 = new Product(0, "Product1", -100);
    Product product2 = new Product(2, "2", 50);
    Product product3 = new Product(100, "Три", 400);
    Product product4 = new Product(4, "", 1000);
    Product product5 = new Product(50, "5+5", 1);
    Product product6 = new Product(6, "@", 0);
    Product product7 = new Book(7, "Book", 300, "Author");
    Product product8 = new Smartphone(-1, "Smartphone", 80_000, "Ы");

    @BeforeEach
    public void setUp() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.save(product7);
        repo.save(product8);
    }

    @Test
    public void shouldShowSaveProducts() {
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8};

        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOneCell() {
        Product[] expected = {product1, product2, product3, product4, product6, product7, product8};

        repo.removeById(50);

        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
