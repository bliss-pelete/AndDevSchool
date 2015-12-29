package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

/**
 * Created by Bliss on 29-Dec-15.
 */

public class BeerInfo {

    private String beer_name;
    private int beer_country;
    private int beer_category;
    private String created;


    public String getBeer_name() {
        return this.beer_name;
    }
    public int getBeer_country () {

        return this.beer_country;
    }

    public int getBeer_category() {

        return  this.beer_category;
    }

    public String getCreated (){

        return this.created;
    }

    public boolean setBeer_name (String name) {

        this.beer_name= name;
        return true;
    }
    public boolean setBeer_country (int country) {

        this.beer_country= country;
        return true;
    }
    public boolean setBeer_category (int category) {

        this.beer_category= category;
        return true;
    }
    public boolean setCreated (String date) {

        this.created= date;
        return true;
    }
}
