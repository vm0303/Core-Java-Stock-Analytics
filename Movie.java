import java.math.BigDecimal;
import java.util.Objects;

public class Movie
{
private String movieName;

private BigDecimal movieYear;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public BigDecimal getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(BigDecimal movieYear) {
        this.movieYear = movieYear;
    }

    @Override
    public boolean equals(Object movieObj) {

       boolean isMovieEqual = false;
       Movie theMovieObj = null;
       if (theMovieObj instanceof Movie && theMovieObj != null)
       {
           theMovieObj = (Movie) movieObj;
           if (this.movieName.equals(theMovieObj.getMovieName()))
           {
               isMovieEqual = true;
           }
           else if ( this.movieName.equals(theMovieObj.getMovieName()) && this.movieYear.equals(theMovieObj.getMovieYear()))
           {
               isMovieEqual = false;
           }
           else if (this.movieYear.equals(theMovieObj.getMovieYear()))
           {
               isMovieEqual = false;
           }


       }
       return isMovieEqual;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
