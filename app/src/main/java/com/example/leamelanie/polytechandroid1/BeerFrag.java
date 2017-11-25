package com.example.leamelanie.polytechandroid1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.leamelanie.polytechandroid1.adapter.BeerAdapter;
import com.example.leamelanie.polytechandroid1.metier.Beer;
import com.example.leamelanie.polytechandroid1.ws.BeerWS;
import com.example.leamelanie.polytechandroid1.ws.DownloadImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mel on 06/11/2017.
 */

public class BeerFrag extends Fragment {

    private ListView beerListView;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_listbeers, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        beerListView = getActivity().findViewById(R.id.listViewBeer);
        progressBar = getActivity().findViewById(R.id.progressBar);

        FrameLayout background = getActivity().findViewById(R.id.background);
        background.setBackgroundResource(R.drawable.beer);
        background.getBackground().setAlpha(30);

        new ListBeersTask().execute();
    }

    class ListBeersTask extends AsyncTask<String,Integer,List<Beer>> {

        ArrayList<Bitmap> imgList = new ArrayList<>();
        int progress;
        Drawable draw=getResources().getDrawable(R.drawable.customprogressbar);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getActivity(), "Veuillez patienter", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate();
            progressBar.setProgress(values[0]);
            progressBar.setProgressDrawable(draw);

        }

        @Override
        protected List<Beer> doInBackground(String...params) {
            BeerWS webService = new BeerWS();

            List<Beer> beersList = webService.getBeers();

            for (Beer b : beersList) {
                DownloadImage img = new DownloadImage(b.image_url);
                imgList.add(img.getImage());

                publishProgress(progress);
                progress++;

            }

            for (progress = 40 ; progress <= 100 ; progress ++)
            {
                for (int i = 0; i < 1000000; i++){}
                publishProgress(progress);
                progress++;
            }

            return beersList;
        }

        @Override
        protected void onPostExecute(List<Beer> beers) {
            super.onPostExecute(beers);
            BeerAdapter adapter = new BeerAdapter(getActivity(), beers, getActivity(), imgList);
            beerListView.setAdapter(adapter);
            Toast.makeText(getActivity(), "Terminé", Toast.LENGTH_LONG).show();

        }

    }
}
