package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Bliss on 31-Dec-15.
 */
public class OpenPandoraDialog  extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.openPandora);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        //what happens when the user clicks ok

                    }
                }
        );

        /*builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){

            public void onClick (DialogInterface dialog,int id) {

                //what happens when the user cancels
            }

        });*/

        return builder.create();

    }
}