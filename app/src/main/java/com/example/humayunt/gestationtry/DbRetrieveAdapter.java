package com.example.humayunt.gestationtry;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

class DbRetrieveAdapter extends Adapter<DbRetrieveAdapter.DataObjectHolder> implements OnClickListener {
    ArrayList<DbEntity> Show;
    private Activity activity;
    private String cat_id;
    private DataObjectHolder holder;
    int i = 0;
    private LayoutInflater mLayoutInflater = null;
    private String name;
    private String str_flag = "";

    public static class DataObjectHolder extends ViewHolder {
        public ImageView img;
        public RelativeLayout layout;
        public TextView tvCity;
        public TextView tvName;

        public DataObjectHolder(View itemView) {
            super(itemView);
            this.layout = (RelativeLayout) itemView.findViewById(R.id.layout);
            this.tvName = (TextView) itemView.findViewById(R.id.txt_name_griditemlayout);
            this.tvCity = (TextView) itemView.findViewById(R.id.txt_city_griditemlayout);
            this.img = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public void onClick(View v) {
    }

    public DbRetrieveAdapter(Activity activity2, ArrayList<DbEntity> contacts) {
        this.activity = activity2;
        this.Show = contacts;
        this.mLayoutInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
    }

    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.holder = new DataObjectHolder(this.mLayoutInflater.inflate(R.layout.layout_grid_item, null));
        return this.holder;
    }

    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        holder.layout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                intent.putExtra("month", ( DbRetrieveAdapter.this.Show.get(position)).getMonth());
                v.getContext().startActivity(intent);
            }
        });
        holder.tvName.setText("Month : " + ( this.Show.get(position)).getMonth());
        holder.tvCity.setText("Fact : " + ( this.Show.get(position)).getFact());
        holder.img.setImageBitmap(( this.Show.get(position)).getImg());
    }

    public int getItemCount() {
        return this.Show.size();
    }
}
