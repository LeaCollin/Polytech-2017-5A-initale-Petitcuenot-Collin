package com.example.leamelanie.polytechandroid1.metier;

import java.util.ArrayList;

/**
 * Created by Mel on 06/11/2017.
 */

public class Beer {
    public int id;
    public String name;
    public String image_url;
    public float abv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }
}
