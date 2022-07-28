package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        if(currentItem.getMovierating().equals("U"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16277-28797ce.jpg?quality=90&webp=true&fit=584,471";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getMovierating().equals("PG"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16278-28797ce.jpg?quality=90&webp=true&fit=584,471";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getMovierating().equals("12A"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16279-8d5bdb7.jpg?quality=90&webp=true&fit=490,490";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getMovierating().equals("12"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16280-8d5bdb7.jpg?quality=90&webp=true&fit=320,320";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getMovierating().equals("15"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16281-8d5bdb7.jpg?quality=90&webp=true&fit=490,490";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getMovierating().equals("18"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16282-05127b2.jpg?quality=90&webp=true&fit=300,300";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getMovierating().equals("R18"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16283-05127b2.jpg?quality=90&webp=true&fit=515,424";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }


        return rowView;
    }
}