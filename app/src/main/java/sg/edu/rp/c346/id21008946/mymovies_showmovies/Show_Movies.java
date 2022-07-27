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

        lvMovies = findViewById(R.id.listViewMoviesList);
        alMovieList = new ArrayList<Movies>();
        caMovie = new CustomAdapter(this,R.layout.row,alMovieList);
        lvMovies.setAdapter(caMovie);

        DBHelper dbh= new DBHelper(Show_Movies.this);
        alMovieList.clear();
        alMovieList.addAll(dbh.getAllMovies());
        caMovie.notifyDataSetChanged();





    }
}
//lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//@Override
//public void onItemClick(AdapterView<?> parent, View view, int
//        position, long identity) {
//        Song data = als.get(position);
//        Intent i = new Intent(SongListActivity.this,
//        SongEditPage.class);
//        i.putExtra("data", data);
//        startActivity(i);
//        }
//        });