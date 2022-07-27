package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class ModifyPage extends AppCompatActivity {

    EditText etMovieID,etMovieTitle,etMovieGenre,etMovieYear;
    Spinner spnGenre;
    ArrayList<Movies> alMovieList;
    CustomAdapter caMovies;
    ArrayList<String> alsMovieList;
    Button btnCancel, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_page);

        etMovieID = findViewById(R.id.editTextMovieID);
        etMovieTitle = findViewById(R.id.editTextMovieTitle);
        etMovieGenre = findViewById(R.id.editTextMovieGenre);
        etMovieYear = findViewById(R.id.editTextMovieYear);
        spnGenre = findViewById(R.id.spinnerMovieRating);
        btnCancel = findViewById(R.id.buttonCancel);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ModifyPage.this);
            }
        });

    }
}

// btnUpdateEDIT.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        DBhelper dbh = new DBhelper(SongEditPage.this);
//        data.setTitle(etSongTitleEDIT.getText().toString());
//        data.setSingers(etSingersNameEDIT.getText().toString());
//        String yeartextEDIT = etYearOfReleaseEDIT.getText().toString();
//        int year = Integer.parseInt(yeartextEDIT);
//        int radioID = rgRatingEDIT.getCheckedRadioButtonId();
//        rb = findViewById(radioID);
//        data.setYear(year);
//        data.setStars(Integer.parseInt(rb.getText().toString()));
//        dbh.updateNote(data);
//        dbh.close();
//
//        finish();
//        }
//        });
//
//        btnDeleteEDIT.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        DBhelper dbh = new DBhelper(SongEditPage.this);
//        int result = dbh.deleteNote(data.getId());
//        Log.d("Result",result+"");
//        finish();
//        }
//        });