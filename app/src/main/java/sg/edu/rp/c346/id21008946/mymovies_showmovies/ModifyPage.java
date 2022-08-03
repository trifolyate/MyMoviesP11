package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ModifyPage extends AppCompatActivity {

    EditText etMovieID, etMovieTitle, etMovieGenre, etMovieYear;
    Spinner spnGenre;
    ArrayList<Movies> alMovieList;
    CustomAdapter caMovies;
    ArrayList<String> alsMovieList;
    Button btnCancel, btnUpdate, btnDelete;
    Movies data;
    String movieRating;

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

        movieRating = "";
        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");

        etMovieID.setText(data.getMovieid() + "");
        etMovieTitle.setText(data.getMovieTitle());
        etMovieGenre.setText(data.getMoviegenre());
        etMovieYear.setText(data.getMovieyear() + "");
        if(data.getMovierating().equals("U"))
        {
            spnGenre.setSelection(0);
        } else if(data.getMovierating().equals("PG"))
        {
            spnGenre.setSelection(1);
        }else if(data.getMovierating().equals("12A"))
        {
            spnGenre.setSelection(2);
        }else if(data.getMovierating().equals("12"))
        {
            spnGenre.setSelection(3);
        }else if(data.getMovierating().equals("15"))
        {
            spnGenre.setSelection(4);
        }else if(data.getMovierating().equals("18"))
        {
            spnGenre.setSelection(5);
        }else if(data.getMovierating().equals("R18"))
        {
            spnGenre.setSelection(6);
        }



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yearS = etMovieYear.getText().toString();
                int yearI = Integer.parseInt(yearS);
                if(yearI < 1888)
                {
                    Toast.makeText(ModifyPage.this,"Please enter the correct year(more than 1888)",Toast.LENGTH_LONG).show();
                }else if(yearI > 2022)
                {
                    Toast.makeText(ModifyPage.this,"Please enter the correct year(less than 2022)",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper dbh = new DBHelper(ModifyPage.this);
                    data.setMovieTitle(etMovieTitle.getText().toString());
                    data.setMoviegenre(etMovieGenre.getText().toString());
                    String yearString = etMovieYear.getText().toString();
                    int year = Integer.parseInt(yearString);
                    data.setMovieyear(year);
                    data.setMovierating(movieRating);
                    dbh.updateNote(data);
                    dbh.close();

                    finish();
                }
//                Toast.makeText(ModifyPage.this, "hi", Toast.LENGTH_SHORT).show();
            }
        });



        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ModifyPage.this);
                int result = dbh.deleteNote(data.getMovieid());
                Log.d("Result", result + "");
                finish();
            }
        });

        spnGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String spinnerItems1 = spnGenre.getSelectedItem().toString();
                        movieRating = spinnerItems1;
                        break;
                    case 1:
                        String spinnerItems2 = spnGenre.getSelectedItem().toString();
                        movieRating = spinnerItems2;
                        break;
                    case 2:
                        String spinnerItems3 = spnGenre.getSelectedItem().toString();
                        movieRating = spinnerItems3;
                        break;
                    case 3:
                        String spinnerItems4 = spnGenre.getSelectedItem().toString();
                        movieRating = spinnerItems4;
                        break;
                    case 4:
                        String spinnerItems5 = spnGenre.getSelectedItem().toString();
                        movieRating = spinnerItems5;
                        break;
                    case 5:
                        String spinnerItems6 = spnGenre.getSelectedItem().toString();
                        movieRating = spinnerItems6;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        etMovieTitle.addTextChangedListener(songInsertTextWatcher);
        etMovieGenre.addTextChangedListener(songInsertTextWatcher);
        etMovieYear.addTextChangedListener(songInsertTextWatcher);
    }
    private TextWatcher songInsertTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String title = etMovieTitle.getText().toString().trim();
            String singers = etMovieGenre.getText().toString().trim();
            String year = etMovieYear.getText().toString().trim();

            if(!title.isEmpty() && !singers.isEmpty() && !year.isEmpty() && year.length()==4)
            {
                btnUpdate.setEnabled(true);
            }
            else
            {
                btnUpdate.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}


//    @Override
//    protected void onResume() {
//        super.onResume();
//        DBHelper dbh = new DBHelper(ModifyPage.this);
//        alMovieList.clear();
//        alMovieList.addAll(dbh.getAllMovies());
//        caMovies.notifyDataSetChanged();
//    }


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