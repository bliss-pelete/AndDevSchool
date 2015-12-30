package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bliss on 29-Dec-15.
 */
public class JSONParser {



    public static List<BeerInfo> parseFeed(JSONArray ze_list) {
            try {
                List<BeerInfo> beerInfoList = new ArrayList<>();


                for (int i=0; i<ze_list.length();i++) {
                    JSONObject one_beer = ze_list.getJSONObject(i);
                    BeerInfo actual_beer = new BeerInfo();
                    actual_beer.setBeer_name(one_beer.getString("name"));
                    actual_beer.setBeer_category(one_beer.getInt("category_id"));
                    actual_beer.setBeer_country(one_beer.getInt("country_id"));
                    actual_beer.setCreated(one_beer.getString("description"));

                    beerInfoList.add(actual_beer);
                }

                return beerInfoList;
            } catch (JSONException e) {
                e.printStackTrace();
              return null;
            }
        }
    }

