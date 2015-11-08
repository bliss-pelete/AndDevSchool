package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        TextView tv_hw= (TextView)findViewById(R.id.tv_hello_world);
        tv_hw.setText(getString(R.string.hello_world) + DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void FunctionOne(View view) {

        Toast.makeText(getApplicationContext(),getString(R.string.msg), Toast.LENGTH_LONG).show();
    }

    public void ShowDatePickerDialog(View view) {
        DialogFragment timep = new DatePickerFragment();
        timep.show(getSupportFragmentManager(),"Date Picker");
    }

    public void ShowUnboxingDialog ( View view ){

        DialogFragment box = new OpenTheBoxDialogFragment();
        box.show(getSupportFragmentManager(),"Open the box");

    }
}
