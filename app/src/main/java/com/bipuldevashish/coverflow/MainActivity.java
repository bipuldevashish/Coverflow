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
            movieList.add(new Movie("Batman vs Superman","data:image/jpeg;base64,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"));
            movieList.add(new Movie("Fast and Furious","https://cdn.movieweb.com/img.site/PHx1qatQr9M5AA_1_l.jpg"));
            movieList.add(new Movie("Wonder Women","data:image/jpeg;base64,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"));
        }
    }