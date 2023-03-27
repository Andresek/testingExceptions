import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product journal = new Product(1, "Журнал", 100);
    Product newspaper = new Product(2, "Газета", 50);
    Product book = new Product(3, "Книга", 500);

    @Test
    public void deletingExistingElement() {

        ShopRepository repo = new ShopRepository();
        repo.add(journal);
        repo.add(newspaper);
        repo.add(book);

        repo.removeById(2);

        Product[] expected = {journal, book};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deletingNotExistingElement() {
        ShopRepository repo = new ShopRepository();
        repo.add(journal);
        repo.add(newspaper);
        repo.add(book);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });

    }

}
