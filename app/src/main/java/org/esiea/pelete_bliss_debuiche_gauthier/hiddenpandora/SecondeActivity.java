package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SecondeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);


        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,  int position, long id) {
                Toast.makeText(SecondeActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

                Intent message = new Intent(Intent.ACTION_SEND);
                message.setType("message/rfc822");
                message.putExtra(Intent.EXTRA_SUBJECT,getResources().getString(R.string.member_request));
                message.putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.member_mail));


                switch(position) {
                    case 0:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"kps@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"dtre@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"air-esiea@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"junior-esiea@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"bdaparis@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"bdeparis@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 6:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"bdsparis@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 7:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"pelete@et.esiea.fr"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 8:
                        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"esiea.event@gmail.com"});

                        try {
                            startActivity(Intent.createChooser(message, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(SecondeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });

    }



}
