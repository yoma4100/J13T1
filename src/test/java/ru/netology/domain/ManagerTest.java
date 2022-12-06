package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.Smartphone;
import ru.netology.repository.Repository;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Product product1 = new Product(0, "Twin", -100);
    Product product2 = new Product(2, "Twin", 50);
    Product product3 = new Product(100, "", 400);
    Product product4 = new Product(4, "4", 1000);
    Product product5 = new Product(50, "5+5", 1);
    Product product6 = new Product(6, "@", 0);
    Product product7 = new Book(7, "Book", 300, "Author");
    Product product8 = new Smartphone(-1, "Smartphone", 80_000, "Ы");

    @BeforeEach
    public void setUp() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
    }

    @Test
    public void shouldRemoveOneCell() {
        Product[] expected = {product1, product2, product3, product4, product6, product7, product8};

        manager.removeById(50);

        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindCellByName() {
        Product[] expected = {product6};
        Product[] actual = manager.searchBy("@");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindCellByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Prfkjsoduct1");

        Assertions.assertArrayEquals(expected, actual);
    }
}
