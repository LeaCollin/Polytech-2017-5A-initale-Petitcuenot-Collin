package com.example.leamelanie.polytechandroid1.ws;

import com.example.leamelanie.polytechandroid1.metier.Beer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit.http.GET;

/**
 * Created by Mel on 06/11/2017.
 */

public class BeerWS {

    public static final String myurl = "https://api.punkapi.com/v2/beers";

    public static List<Beer> getBeers() {

        ArrayList<Beer> beersList = new ArrayList<>();

        try {
            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();

            String result = InputStreamOperations.InputStreamToString(inputStream);

            // On récupère le JSON
            JSONArray array = new JSONArray(result);
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                // On fait le lien Personne - Objet JSON
                Beer beer = new Beer();
                beer.setImage_url(obj.getString("image_url"));
                beer.setName(obj.getString("name"));
                beer.setAbv(Float.valueOf(obj.getString("abv")));
                // On ajoute la personne à la liste
                beersList.add(beer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des beersList
        return beersList;
    }
}

