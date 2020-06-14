import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CinemaTest {
    private static Cinema cinema;

    @Before
    public void setUp(){
        cinema = new Cinema(new Time(30, 8), new Time(30, 22));
    }

    @Test
    public void addMovieTest(){
        boolean realAdd = cinema.addMovie(new Movie("Фільм", new Time(30, 1)));
        boolean expectedAdd = true;
        Assert.assertEquals(expectedAdd, realAdd);
    }

    //bad test
    @Test
    public void addSeanceTest(){
        Seance[] seances = new Seance[] {new Seance("Фільм", new Time(30, 9), new Time(40, 10))};
        cinema.addSeance(seances, "Monday");
        Assert.assertNotNull(cinema.schedules);
    }

    @Test
    public void removeMovieTest(){
        Movie realAdd = cinema.removeMovie(new Movie("Фільм", new Time(30, 1)));
        Assert.assertNull(realAdd);
    }

    @AfterClass
    public static void tearDown() {
        cinema = null;
    }

}
