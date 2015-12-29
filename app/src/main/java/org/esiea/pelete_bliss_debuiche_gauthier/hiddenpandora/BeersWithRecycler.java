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
import java.util.List;

public class BeersWithRecycler extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public JSONArray beerArray = getBeersFromFile();
    private List<BeerInfo> ze_list = new ArrayList<>();
   // private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers_with_recycler);
        ze_list = JSONParser.parseFeed(beerArray);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_biere);
        mLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new BeersAdapter(ze_list));
        mRecyclerView.setHasFixedSize(true);


    }
    private class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeerHolder> {

       // private JSONArray beers;
        private List<BeerHolder> beerslst;

        public BeersAdapter(List<BeerInfo> ze_list) {

            this.beerslst = beerslst;

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
        public void onBindViewHolder(BeersAdapter.BeerHolder holder, final int position) {

            JSONObject the_beer=null;
            String beer_name=null;

            BeerInfo one_beer = ze_list.get(position);
            holder.name.setText(one_beer.getBeer_name());




        }



        @Override
        public int getItemCount() {

            Log.d("TAG", "item size " + beerslst.size());
            return beerslst.size();
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

