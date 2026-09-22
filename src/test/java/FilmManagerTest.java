import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {
    FilmsManager manager = new FilmsManager();

    @Test
    public void shouldReturnEmptyArrayWhenNoFilmsAdded() {

        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndFindAllFilmsAdd1() {
        manager.addFilm("Movie I");

        String[] actual = manager.findAll();
        String[] expected = {"Movie I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndFindAllFilmsAdd3() {
        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");

        String[] actual = manager.findAll();
        String[] expected = {
                "Movie I",
                "Movie II",
                "Movie III"
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenFilmsEqualToDefaultLimitAdd5() {

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");
        manager.addFilm("Movie V");

        String[] expected = {
                "Movie V",
                "Movie IV",
                "Movie III",
                "Movie II",
                "Movie I"
        };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenFilmsMoreThanDefaultLimitAdd6() {

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");
        manager.addFilm("Movie V");
        manager.addFilm("Movie VI");

        String[] expected = {
                "Movie VI",
                "Movie V",
                "Movie IV",
                "Movie III",
                "Movie II"
        };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimit3() {
        FilmsManager manager = new FilmsManager(3);

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");

        String[] expected = {
                "Movie IV",
                "Movie III",
                "Movie II"
        };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}