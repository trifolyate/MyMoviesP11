package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Show_Movies extends AppCompatActivity {

    ListView lvMovies;
    Button btnShowAll;
    Spinner spnRating;
    CustomAdapter caMovie;
    ArrayList<Movies> alMovieList;
    String movieRating;

    Movies data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        lvMovies = findViewById(R.id.listViewMoviesList);
        alMovieList = new ArrayList<Movies>();
        caMovie = new CustomAdapter(this,R.layout.row,alMovieList);
        lvMovies.setAdapter(caMovie);
        btnShowAll = findViewById(R.id.btnShowMovies);
        spnRating = findViewById(R.id.spinnerRatings);
        movieRating = "";

        DBHelper dbh= new DBHelper(Show_Movies.this);
        alMovieList.clear();
        alMovieList.addAll(dbh.getAllMovies());
        caMovie.notifyDataSetChanged();

        spnRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String spinnerItems1 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems1;
                        break;
                    case 1:
                        String spinnerItems2 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems2;
                        break;
                    case 2:
                        String spinnerItems3 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems3;
                        break;
                    case 3:
                        String spinnerItems4 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems4;
                        break;
                    case 4:
                        String spinnerItems5 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems5;
                        break;
                    case 5:
                        String spinnerItems6 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems6;
                        break;
                    case 6:
                        String spinnerItems7 = spnRating.getSelectedItem().toString();
                        movieRating = spinnerItems7;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(Show_Movies.this);
                alMovieList.clear();
                alMovieList.addAll(dbh.getAllMovies(movieRating));
                caMovie.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(Show_Movies.this);
        alMovieList.clear();
        alMovieList.addAll(dbh.getAllMovies());
        caMovie.notifyDataSetChanged();
    }
}