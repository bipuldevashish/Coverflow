package com.bipuldevashish.coverflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private List<Movie> movieList;
    private Context mContext;

    public MovieAdapter(List<Movie> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null ){
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item,null);
            TextView name = rowView.findViewById(R.id.label);
            ImageView image = rowView.findViewById(R.id.image);

            //for setting Data
            Picasso.get().load(movieList.get(i).getImageURL()).into(image);
            name.setText(movieList.get(i).getName());
        }
        return rowView;
    }
}
