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
        movie3.setMovieName("Gravity");
        movie3.setMovieYear(new BigDecimal("2013"));
        
        Movie movie4 = new Movie();
        movie4.setMovieName("Twilight");
        movie4.setMovieYear(new BigDecimal("2008"));


        Movie movie5 = new Movie();
        movie5.setMovieName("Megamind");
        movie5.setMovieYear(new BigDecimal("2014"));


        if (movie1.equals(movie2))
        {
            System.out.println("Both movies are the same");
        }
        else
        {
            System.out.println("Both movies are different because " +
                    "of the years they were released.");
        }
        if (movie3.equals(movie5))
        {
            System.out.println("Movie 3 and Movie are the same");
        }
        else
        {
            System.out.println("Movie 3 and Movie 5 are NOT the same");
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
