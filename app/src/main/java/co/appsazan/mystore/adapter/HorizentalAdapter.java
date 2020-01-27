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
import co.appsazan.mystore.activity.FirstActivity;
import co.appsazan.mystore.activity.SecondActivity;
import co.appsazan.mystore.myview.MyTextView;
import co.appsazan.mystore.model.to.AppListStruct;

/**
 * Created by Ali on 9/17/2016.
 */
public class HorizentalAdapter extends RecyclerView.Adapter<HorizentalAdapter.MyViewHolder> {
    private List<AppListStruct> horizontalList;




    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout cardView;
        public MyTextView appName;
        public MyTextView Appdesc;
        public ImageView imgview;

        public MyViewHolder(View view) {
            super(view);

            appName = (MyTextView) view.findViewById(R.id.card_txt);
            Appdesc = (MyTextView) view.findViewById(R.id.desc_txt);
            imgview = (ImageView) view.findViewById(R.id.card_img);
            cardView = (RelativeLayout) view.findViewById(R.id.card_view);

        }


    }

    public HorizentalAdapter(List<AppListStruct> horizontalList) {

        this.horizontalList = horizontalList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_horizental, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(HorizentalAdapter.MyViewHolder holder, final int position) {


        holder.appName.setText(horizontalList.get(position).appname);
        holder.Appdesc.setText(horizontalList.get(position).desc);
        Picasso.with(Config.context).load(horizontalList.get(position).imgurl).into(holder.imgview);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Config.context, SecondActivity.class);
                //  intent.putExtra("appName","appName");
                intent.putExtra("appName", horizontalList.get(position).appname);
                //  intent.putExtra("appDesc","appDesk");
                intent.putExtra("appDesc", horizontalList.get(position).desc);
                // intent.putExtra("appImg","appImg");
                intent.putExtra("appImg", horizontalList.get(position).imgurl);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Config.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
