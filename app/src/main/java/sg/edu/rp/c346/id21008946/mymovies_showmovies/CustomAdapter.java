package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> moviesList;

    public CustomAdapter(Context context,int resource,ArrayList<Movies> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        moviesList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);

        Movies currentItem = moviesList.get(position);
        tvTitle.setText(currentItem.getMovieTitle());
        tvGenre.setText("+" + currentItem.getMoviegenre());
        tvYear.setText(currentItem.getMovieyear() + "");
        // G,M18,NC16,PG,PG13,R21

        if(currentItem.getMovierating() == "G")
        {
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if (currentItem.getMovierating() == "PG")
        {
            ivRating.setImageResource(R.drawable.rating_pg);
        }
//        else if (currentItem.getMovierating() == "PG13")
//        {
//            ivRating.setImageResource(R.drawable.rating_pg13);
//        }
//        else if (currentItem.getMovierating() == "NC16")
//        {
//            ivRating.setImageResource(R.drawable.rating_nc16);
//        }
//        else if (currentItem.getMovierating() == "M18")
//        {
//            ivRating.setImageResource(R.drawable.rating_m18);
//        }
//        else if (currentItem.getMovierating() == "R21")
//        {
//            ivRating.setImageResource(R.drawable.rating_r21);
//        }


        return rowView;
    }
}