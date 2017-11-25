package com.example.leamelanie.polytechandroid1.ws;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mel on 07/11/2017.
 */

public class DownloadImage {

    public String url;

    public DownloadImage(String url) {
        this.url = url;
    }

    public Bitmap getImage(){

        Bitmap bitmap = null;
        try {
            URL urlImg = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlImg.openConnection();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
