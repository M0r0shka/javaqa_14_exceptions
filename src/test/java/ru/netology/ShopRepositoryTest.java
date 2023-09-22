package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShopRepositoryTest {

    Product product1 = new Product(12, "хлеб", 40);
    Product product2 = new Product(23, "булка", 30);
    Product product3 = new Product(45, "картошка", 20);
    Product product4 = new Product(31, "яблоко", 15);
    Product product5 = new Product(23, "груша", 15);

    @Test
    public void testNotFoundExceptionItemNotFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(8);
        });
    }

    @Test
    public void testNotFoundExceptionItemFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(45);


        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddToArray() {

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);


        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testAddToArrayAlreadyExist() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
       // repo.add(product5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product5);
        });
    }



}
