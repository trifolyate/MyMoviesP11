package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvGenre, tvYear, tvRating;
    EditText etTitle, etGenre, etYear;
    Spinner spnRating;
    Button btnInsert, btnShowList;
//    ListView lvTest;
//    ArrayList<Movies> alMovieList;
//    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvTitle = findViewById(R.id.tvTitle);
        tvGenre = findViewById(R.id.tvGenre);
        tvYear =findViewById(R.id.tvYear);
        tvRating =findViewById(R.id.tvRating);
        etTitle =findViewById(R.id.etTitle);
        etGenre =findViewById(R.id.etGenre);
        etYear =findViewById(R.id.etYear);
        spnRating =findViewById(R.id.spnRating);
        btnInsert =findViewById(R.id.btnInsert);
        btnShowList =findViewById(R.id.btnShowList);

        //test
//        lvTest = findViewById(R.id.listViewTest);
//        alMovieList = new ArrayList<>();
//        caMovie = new CustomAdapter(this,R.layout.row,alMovieList);
//        lvTest.setAdapter(caMovie);

        populateData();

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Show_Movies.class);
                startActivity(i);
            }});

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movietitle = etTitle.getText().toString();
                String moviegenre = etGenre.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String movierating = "TEST";
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id =dbh.insertMovie(movietitle,moviegenre,year,movierating);
                if (inserted_id != -1) {
//                    alMovieList.clear();
//                    alMovieList.addAll(dbh.getAllMovies());
//                    caMovie.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert not successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    void populateData(){
        DBHelper dbh = new DBHelper(MainActivity.this);
        dbh.insertMovie("Title","Genre",2111,"Nice");
//        alMovieList.clear();
//        alMovieList.addAll(dbh.getAllMovies());
//        caMovie.notifyDataSetChanged();
    }
}
