package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClubsInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_info);
    }





    public void showClubInfo ( View view ){

        int id= view.getId();


        switch (id) {
            case R.id.ib_airesiea:
                DialogFragment box = new OpenAIRDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case  R.id.ib_bda:
                box = new OpenBDADialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_bde:
                 box = new OpenBDEDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_bds:
                box = new OpenBDSDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_dtre:
                box= new OpenDTREDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_kps:
                box = new OpenKPSDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_je:
                box= new OpenJUNIORDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_triangle:
                box= new OpenEvent();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;
            case R.id.ib_double_hex:
                box= new OpenPandoraDialog();
                box.show(getSupportFragmentManager(), String.valueOf(R.string.the_more_u_no));
                break;


        }

    }
}
