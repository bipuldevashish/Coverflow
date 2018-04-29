package com.bipuldevashish.coverflow;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {


    private FeatureCoverFlow coverFlow;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList = new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mTitle = findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView txt = (TextView) inflater.inflate(R.layout.layout_title, null);
                return txt;
                }
            });

            Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
            Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
            mTitle.setInAnimation(in);
            mTitle.setOutAnimation(out);

            movieAdapter =new MovieAdapter(movieList,this);
            coverFlow =(FeatureCoverFlow)findViewById(R.id.coverFlow);
            coverFlow.setAdapter(movieAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener(){
                @Override
                    public void onScrolledToPosition(int position){

                    mTitle.setText(movieList.get(position).getName());
            }
                @Override
                public void onScrolling(){

                }

            });
        }

        private void initData(){

            movieList.add(new Movie("Civil War","https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/a/a5/Civil_War_Alternate_poster.jpg/revision/latest?cb=20160330133735"));
            movieList.add(new Movie("Batman vs Superman","https://trashfilmguru.files.wordpress.com/2016/03/batman-vs-superman-poster.jpg"));
            movieList.add(new Movie("Fast and Furious","https://cdn.movieweb.com/img.site/PHx1qatQr9M5AA_1_l.jpg"));
            movieList.add(new Movie("Wonder Women","http://www.joblo.com/posters/images/full/wonder-woman-new-poster.jpg"));
        }
    }
