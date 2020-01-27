package co.appsazan.mystore.adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;

/**
 * Created by Ali on 9/19/2016.
 */
public class ScreenShotAdapter extends RecyclerView.Adapter<ScreenShotAdapter.MyViewHolder> {
    private List<String> horizontalList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgview;

        public MyViewHolder(View view) {
            super(view);
            imgview = (ImageView) view.findViewById(R.id.screenshoot);


        }
    }

    public ScreenShotAdapter(List<String> horizontalList) {
        this.horizontalList = horizontalList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.screenshoot, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Picasso.with(Config.context).load(horizontalList.get(position)).into(holder.imgview);


    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
