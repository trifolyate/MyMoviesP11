package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Show_Movies extends AppCompatActivity {

    ListView lvMovies;
    Button btnShowAllPG13;
    CustomAdapter caMovie;
    ArrayList<Movies> alMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        //DBHelper dbh= new DBHelper(Show_Movies.this);
        //alMovieList.clear;
        //alMovieList.addAll(dbh.getAllMovies());
        //caMovie.notifyDataChange();





    }
}