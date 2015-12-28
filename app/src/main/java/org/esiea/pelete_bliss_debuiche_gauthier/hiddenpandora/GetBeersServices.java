package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetBeersServices extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS

    private static final String ACTION_get_all_beers = "org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora.action.FOO";
    public static final String TAG = "TAG";

     public static void startActionget_all_beers(Context context) {
        Intent intent = new Intent(context, GetBeersServices.class);
        intent.setAction(ACTION_get_all_beers);
        context.startService(intent);
    }


    public GetBeersServices() {
        super("GetBeersServices");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_get_all_beers.equals(action)) {
                handleAction_get_all_beers();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void copyInputStreamToFile (InputStream in,File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0) {
                out.write(buf,0,len);
            }

            out.close();
            in.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void handleAction_get_all_beers() {
        // TODO: Handle action Foo



        Log.d(TAG,"Thread service name:" + Thread.currentThread().getName());
        URL url = null;
        try {
            url = new URL("http://binouze.fabrigli.fr/bieres.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "bieres.json"));
                Log.d(TAG, "Bieres json downloaded !");

                // LocalBroadcastManager.getInstance(this).sendBroadcast(new OnBeerJsonDownload(),intentfilter);
                Intent i = new Intent("BEERS_UPDATE");
                sendBroadcast(i);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
