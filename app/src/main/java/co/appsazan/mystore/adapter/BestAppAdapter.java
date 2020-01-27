package co.appsazan.mystore.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.model.to.MyBestApp;
import co.appsazan.mystore.myview.MyTextView;

/**
 * Created by Ali on 10/18/2016.
 */
public class BestAppAdapter extends RecyclerView.Adapter<BestAppAdapter.MyViewHolder> {
    private List<MyBestApp> myList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView relativeLayout;
        public ImageView imgview;
        public MyTextView txtTitleView;
        public MyTextView txtAuthorView;

        public MyViewHolder(View view) {
            super(view);
            imgview = (ImageView) view.findViewById(R.id.imgBAL);
            txtTitleView = (MyTextView) view.findViewById(R.id.txtTitleBAL);
            txtAuthorView = (MyTextView) view.findViewById(R.id.txtDescBAL);
            relativeLayout = (CardView) view.findViewById(R.id.relBestApp);
        }

    }

    public BestAppAdapter(List<MyBestApp> myList) {
        this.myList = myList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_best_app, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BestAppAdapter.MyViewHolder holder, final int position) {
        Picasso.with(Config.context).load(myList.get(position).getImage()).into(holder.imgview);
        holder.txtTitleView.setText(myList.get(position).getTitle());
        holder.txtAuthorView.setText(myList.get(position).getDesc());
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
        return myList.size();
    }

}