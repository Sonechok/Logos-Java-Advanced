import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CinemaTest {
    private static lesson1_junit.Cinema cinema;

    @Before
    public void setUp(){
        cinema = new lesson1_junit.Cinema(new lesson1_junit.Time(30, 8), new lesson1_junit.Time(30, 22));
    }

    @Test
    public void addMovieTest(){
        boolean realAdd = cinema.addMovie(new lesson1_junit.Movie("Фільм", new lesson1_junit.Time(30, 1)));
        boolean expectedAdd = true;
        Assert.assertEquals(expectedAdd, realAdd);
    }

    //bad test
    @Test
    public void addSeanceTest(){
        lesson1_junit.Seance[] seances = new lesson1_junit.Seance[] {new lesson1_junit.Seance("Фільм", new lesson1_junit.Time(30, 9), new lesson1_junit.Time(40, 10))};
        cinema.addSeance(seances, "Monday");
        Assert.assertNotNull(cinema.schedules);
    }

    @Test
    public void removeMovieTest(){
        lesson1_junit.Movie realAdd = cinema.removeMovie(new lesson1_junit.Movie("Фільм", new lesson1_junit.Time(30, 1)));
        Assert.assertNull(realAdd);
    }

    @AfterClass
    public static void tearDown() {
        cinema = null;
    }

}
