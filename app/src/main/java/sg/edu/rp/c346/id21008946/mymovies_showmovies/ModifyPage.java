package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class ModifyPage extends AppCompatActivity {

    EditText etMovieID,etMovieTitle,etMovieGenre,etMovieYear;
    Spinner spnGenre;
    ArrayList<Movies> alMovieList;
    CustomAdapter caMovies;
    ArrayList<String> alsMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_page);

        etMovieID = findViewById(R.id.editTextMovieID);
        etMovieTitle = findViewById(R.id.editTextMovieTitle);
        etMovieGenre = findViewById(R.id.editTextMovieGenre);
        etMovieYear = findViewById(R.id.editTextMovieYear);
        spnGenre = findViewById(R.id.spinnerMovieRating);
    }
}