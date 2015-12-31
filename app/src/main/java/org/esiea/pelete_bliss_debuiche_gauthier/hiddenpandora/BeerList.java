package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.cert.PKIXCertPathBuilderResult;
import java.util.List;

public class BeerList extends AppCompatActivity {


    String reason = new String();
    EditText myEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


public void DownloadBeerlist (View view ){

    GetBeersServices.startActionget_all_beers(this);


}
    public void LookUpList ( View view) {

        Intent i = new Intent(this,BeersWithRecycler.class);
        startActivity(i);

    }

    public void submit_text (View view) {

        myEdit= (EditText)findViewById(R.id.et_reason_drink);
        reason= myEdit.getText().toString();
        Toast.makeText(getApplicationContext(),reason,Toast.LENGTH_LONG).show();
    }

}
