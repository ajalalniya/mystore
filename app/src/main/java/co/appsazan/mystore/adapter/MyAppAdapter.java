package co.appsazan.mystore.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.model.to.MyApp;
import co.appsazan.mystore.myview.MyButton;
import co.appsazan.mystore.myview.MyTextView;
import co.appsazan.mystore.myview.MyTextViewBold;

/**
 * Created by Ali on 10/18/2016.
 */
public class MyAppAdapter extends RecyclerView.Adapter<MyAppAdapter.MyViewHolder> {
    private List<MyApp> myList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout relativeLayout;
        public ImageView imgview;
        public MyTextViewBold txtTitleView;
        public MyTextView txtAuthorView;
        public MyButton myBtn;
        public RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            imgview = (ImageView) view.findViewById(R.id.imgMAL);
            txtTitleView = (MyTextViewBold) view.findViewById(R.id.txtTitleMAL);
            txtAuthorView = (MyTextView) view.findViewById(R.id.txtDescMAL);
            myBtn=(MyButton) view.findViewById(R.id.btnDetailMAL);
            ratingBar=(RatingBar) view.findViewById(R.id.ratingBarMAL);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.relAppMyList);
        }

    }

    public MyAppAdapter(List<MyApp> myList) {
        this.myList = myList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_app, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyAppAdapter.MyViewHolder holder, final int position) {



        Picasso.with(Config.context).load(myList.get(position).getImage()).into(holder.imgview);
        holder.txtTitleView.setText(myList.get(position).getTitle());
        holder.txtAuthorView.setText(myList.get(position).getAuthor());
        holder.ratingBar.setRating(myList.get(position).getRate());

        holder.myBtn.setOnClickListener(new View.OnClickListener() {
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
