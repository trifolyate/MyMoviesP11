package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CustomAdapter caMovie;
    ArrayList<Movies> alMovieList;
    TextView tvTitle, tvGenre, tvYear, tvRating;
    EditText etTitle, etGenre, etYear;
    Spinner spnRating;
    Button btnInsert, btnShowList;

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

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Show_Movies.class);
                startActivity(i);
            }});


    }
}
