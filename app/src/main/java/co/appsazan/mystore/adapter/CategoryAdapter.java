package co.appsazan.mystore.adapter;

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
import co.appsazan.mystore.model.to.MyCategory;
import co.appsazan.mystore.model.to.MyCollection;
import co.appsazan.mystore.myview.MyTextView;

/**
 * Created by Ali on 10/16/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private List<MyCategory> categoryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout relativeLayout;
        public ImageView imgview;
        public MyTextView txtview;

        public MyViewHolder(View view) {
            super(view);
            imgview = (ImageView) view.findViewById(R.id.imgCategoryItem);
            txtview = (MyTextView) view.findViewById(R.id.txtCategoryItem);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.relCategoryItem);
        }

    }

    public CategoryAdapter(List<MyCategory> categoryList) {
        this.categoryList = categoryList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_category, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, final int position) {


       holder.imgview.setImageResource(categoryList.get(position).getImage());
        holder.txtview.setText(categoryList.get(position).getTitle());
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
        return categoryList.size();
    }

}
