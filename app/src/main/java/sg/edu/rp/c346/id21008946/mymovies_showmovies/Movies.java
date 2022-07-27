package sg.edu.rp.c346.id21008946.mymovies_showmovies;

public class Movies {
    private String movieTitle;
    private String moviegenre;
    private int movieyear;
    private char movierating;

    public Movies(String movieTitle, String moviegenre, int movieyear, char movierating) {
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

    public char getMovierating() {
        return movierating;
    }

    public void setMovierating(char movierating) {
        this.movierating = movierating;
    }


}
