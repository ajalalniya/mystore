package co.appsazan.mystore.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.activity.SecondActivity;
import co.appsazan.mystore.model.to.AppListStruct;
import co.appsazan.mystore.model.to.MyCollection;
import co.appsazan.mystore.myview.MyTextView;

/**
 * Created by Ali on 10/2/2016.
 */
public class CollactionAdapter extends RecyclerView.Adapter<CollactionAdapter.MyViewHolder> {
    private List<MyCollection> horizontalList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout relativeLayout;
        public ImageView imgview;

        public MyViewHolder(View view) {
            super(view);
            imgview = (ImageView) view.findViewById(R.id.imgCollaction);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.relCollaction);
        }

    }

    public CollactionAdapter(List<MyCollection> horizontalList) {
        this.horizontalList = horizontalList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_collaction, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CollactionAdapter.MyViewHolder holder, final int position) {


        Picasso.with(Config.context).load(horizontalList.get(position).imgurl).into(holder.imgview);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Intent intent = new Intent(activity, SecondActivity.class);
                activity.startActivity(intent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}


