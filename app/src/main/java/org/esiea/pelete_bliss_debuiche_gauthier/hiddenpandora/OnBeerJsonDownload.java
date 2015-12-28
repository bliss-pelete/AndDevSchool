package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Bliss on 07-Dec-15.
 */
public class OnBeerJsonDownload extends BroadcastReceiver {


    public static final String TAG ="Beer downloaded";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,intent.getAction());

            PendingIntent pi= PendingIntent.getActivity(context,0,new Intent(context,BeersWithRecycler.class),0);
            NotificationCompat.Builder notif=  new NotificationCompat.Builder(context);
            notif.setSmallIcon(R.drawable.bell_sound_notification);
            notif.setContentText("Your beer list is ready");
            notif.setContentTitle("List of beers");
            notif.setContentIntent(pi);
            notif.setPriority(0);
            notif.setAutoCancel(true);

            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(14, notif.build());

    }
}
