package sg.edu.rp.c346.id21008946.mymovies_showmovies;

public class Movies {
    private int movieid;
    private String movieTitle;
    private String moviegenre;
    private int movieyear;
    private String movierating;

    public Movies(int movieid, String movieTitle, String moviegenre, int movieyear, String movierating) {
        this.movieid = movieid;
        this.movieTitle = movieTitle;
        this.moviegenre = moviegenre;
        this.movieyear = movieyear;
        this.movierating = movierating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviegenre() {
        return moviegenre;
    }

    public void setMoviegenre(String moviegenre) {
        this.moviegenre = moviegenre;
    }

    public int getMovieyear() {
        return movieyear;
    }

    public void setMovieyear(int movieyear) {
        this.movieyear = movieyear;
    }

    public String getMovierating() {
        return movierating;
    }

    public void setMovierating(String movierating) {
        this.movierating = movierating;
    }
}
