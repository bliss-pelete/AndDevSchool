package org.esiea.pelete_bliss_debuiche_gauthier.hiddenpandora;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by Bliss on 28-Nov-15.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext  = c;
    }

    @Override
    public int getCount() {

        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageview;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageview = new ImageView(mContext);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageview.setPadding(8, 8, 8, 8);
        } else {
            imageview = (ImageView) convertView;
        }

        imageview.setImageResource(mThumbIds[position]);
        return imageview;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.icon_kps, R.drawable.icon_dtre,
            R.drawable.icon_airesiea, R.drawable.icon_junior,
            R.drawable.icon_bda, R.drawable.icon_square,
            R.drawable.icon_penta, R.drawable.icon_double_hex,
            R.drawable.icon_op_red


      };

}
