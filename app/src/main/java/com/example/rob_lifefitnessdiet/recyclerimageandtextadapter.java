package com.example.rob_lifefitnessdiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recyclerimageandtextadapter extends RecyclerView.Adapter<recyclerimageandtextadapter.ViewHolder> {

    private Context context;
    private ArrayList<imageandtextmodel> imageandtextmodelArrayList;



    public recyclerimageandtextadapter(Context context, ArrayList<imageandtextmodel> imageandtextmodelArrayList) {
        this.context= context;
        this.imageandtextmodelArrayList = imageandtextmodelArrayList;
    }

    @NonNull
    @Override
    public recyclerimageandtextadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.imageandtext,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //holder.contentview.setText(user.getContent());





        Glide.with(context).load(imageandtextmodelArrayList.get(position).getImageurl()).into(holder.imageviewforrvandtext);
        holder.contentviewinfo.setText(imageandtextmodelArrayList.get(position).getContentinfo());
        holder.header.setText(imageandtextmodelArrayList.get(position).getHeader());
    }

    @Override
    public int getItemCount() {
        return imageandtextmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageviewforrvandtext;
        TextView contentviewinfo;
        TextView header;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageviewforrvandtext=itemView.findViewById(R.id.imageviewforrvandtext);
            contentviewinfo=itemView.findViewById(R.id.Contentinfo);
            header=itemView.findViewById(R.id.header);

        }
    }
}