import java.math.BigDecimal;
import java.util.Objects;

public class MovieManager
{
    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setMovieName("The Avengers");
        movie1.setMovieYear(new BigDecimal("2012"));

        Movie movie2 = new Movie();
        movie2.setMovieName("The Avengers");
        movie2.setMovieYear(new BigDecimal("1998"));

        Movie movie3 = new Movie();
        movie3.setMovieName("Heat");
        movie3.setMovieYear(new BigDecimal("1995"));


        Movie movie4 = new Movie();
        movie4.setMovieName("Twilight");
        movie4.setMovieYear(new BigDecimal("2008"));


        Movie movie5 = new Movie();
        movie5.setMovieName("The Avengers");
        movie5.setMovieYear(new BigDecimal("1998"));


        if (movie1.equals(movie2))
        {
            System.out.println("Both movies are the same");
        }
        else
        {
            System.out.println("Both movies are different because " +
                    "of the years they were released.");
        }
        if (movie3.equals(null))
        {
            System.out.println("Movie 3 is null.");
        }
        else
        {
            System.out.println("Movie 3 is NOT null and has the movie name " + movie3.getMovieName() +
                    ", which was released in the year " + movie3.getMovieYear());
        }


        if (movie1.getMovieName().equals(movie2.getMovieName()))
        {
            System.out.println("Both movies have the same name.");
        }
        else
        {
            System.out.println("Both movies have different names.");
        }

        if (movie4.getMovieName().equals(movie5.getMovieName()))
        {
            System.out.println("Both movies have the same name.");
        }
        else
        {
            System.out.println("Both movies have different names.");
        }





    }
}
