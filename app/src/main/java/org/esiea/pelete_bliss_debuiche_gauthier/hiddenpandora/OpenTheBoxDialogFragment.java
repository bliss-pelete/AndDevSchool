package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora.R;


/**
 * Created by Bliss on 23-Oct-15.
 */
public class OpenTheBoxDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Open the box");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        //what happens when the user clicks ok

                    }
                }
        );

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){

                    public void onClick (DialogInterface dialog,int id) {

                        //what happens when the user cancels
                    }

        });

        return builder.create();

    }
}
