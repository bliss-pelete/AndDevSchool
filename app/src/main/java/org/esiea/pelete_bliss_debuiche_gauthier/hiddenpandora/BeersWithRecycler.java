package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BeersWithRecycler extends AppCompatActivity {

    private RecyclerView mRecyclerView;
   // private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers_with_recycler);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_biere);
        mLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new BeersAdapter(getBeersFromFile()));
        mRecyclerView.setHasFixedSize(true);


    }
    private class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeerHolder> {

        private JSONArray beers;

        public BeersAdapter(JSONArray beers) {

            this.beers=beers;

        }


        public class BeerHolder extends RecyclerView.ViewHolder{

            public TextView name;
            public BeerHolder(View itemView) {
                super(itemView);
                name= (TextView) itemView;
            }


        }

        @Override
        public BeersAdapter.BeerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View beerview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_beer_element,parent,false);


            BeerHolder bh= new BeerHolder(beerview);

            return bh;
        }

        @Override
        public void onBindViewHolder(BeersAdapter.BeerHolder holder, int position) {

            JSONObject the_beer=null;
            String beer_name=null;

            try {
                the_beer.getJSONObject(String.valueOf(position));
                beer_name=the_beer.getString("name");
                holder.name.setText(beer_name);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public int getItemCount() {

            Log.d("TAG", "item size " + beers.length());
            return beers.length();
        }
    }




// cette fonction permet de constuire le tableau json
    public JSONArray getBeersFromFile() {

        try {
            InputStream is = new FileInputStream(getCacheDir()+"/"+ "bieres.json");
            byte [] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer,"UTF-8"));
            } catch ( IOException e) {
            e.printStackTrace();

            return new JSONArray();
        }
        catch (JSONException e) {
            e.printStackTrace();

            return new JSONArray();
        }
    }



    }

