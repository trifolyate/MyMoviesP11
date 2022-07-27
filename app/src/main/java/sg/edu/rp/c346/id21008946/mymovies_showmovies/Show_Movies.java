package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Show_Movies extends AppCompatActivity {

    ListView lvMovies;
    Button btnShowAllPG13;
    CustomAdapter caMovie;
    ArrayList<Movies> alMovieList;
    Movies data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        lvMovies = findViewById(R.id.listViewMoviesList);
        alMovieList = new ArrayList<Movies>();
        caMovie = new CustomAdapter(this,R.layout.row,alMovieList);
        lvMovies.setAdapter(caMovie);

        DBHelper dbh= new DBHelper(Show_Movies.this);
        alMovieList.clear();
        alMovieList.addAll(dbh.getAllMovies());
        caMovie.notifyDataSetChanged();

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Movies data = alMovieList.get(position);
                Intent i = new Intent(Show_Movies.this,
                        ModifyPage.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

    }
}