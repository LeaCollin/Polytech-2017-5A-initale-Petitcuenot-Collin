package com.example.leamelanie.polytechandroid1.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leamelanie.polytechandroid1.R;
import com.example.leamelanie.polytechandroid1.metier.Beer;
import com.example.leamelanie.polytechandroid1.metier.BeerViewHolder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mel on 06/11/2017.
 */

public class BeerAdapter extends ArrayAdapter<Beer> {

    public Activity activity;
    public ArrayList<Bitmap> imgList;

    public BeerAdapter(Context context, List<Beer> beers, Activity activity, ArrayList<Bitmap> imgList){
        super(context, 0, beers);
        this.activity = activity;
        this.imgList = imgList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.frag_rowbeer,parent, false);
        }

        BeerViewHolder viewHolder = (BeerViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new BeerViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.alcool = (TextView) convertView.findViewById(R.id.alcool);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Beer beer = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(beer.getName());
        viewHolder.alcool.setText(Float.toString(beer.getAbv()));
        viewHolder.img.setImageBitmap(imgList.get(position));





        return convertView;
    }
}
