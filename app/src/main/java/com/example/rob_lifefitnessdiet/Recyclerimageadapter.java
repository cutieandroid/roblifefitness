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

public class Recyclerimageadapter extends RecyclerView.Adapter<Recyclerimageadapter.ViewHolder> {

    private Context contextl;
    private ArrayList<imagemmodel> imagemmodelArrayList;



    public Recyclerimageadapter(Context contextl, ArrayList<imagemmodel> imagemmodelArrayList) {
        this.contextl = contextl;
        this.imagemmodelArrayList = imagemmodelArrayList;
    }

    @NonNull
    @Override
    public Recyclerimageadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singleiamge,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //holder.contentview.setText(user.getContent());





        Glide.with(contextl).load(imagemmodelArrayList.get(position).getImageurl()).into(holder.imageviewforrv);
        holder.contentview.setText(imagemmodelArrayList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return imagemmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

      ImageView imageviewforrv;
      TextView contentview;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageviewforrv=itemView.findViewById(R.id.imageviewforrv);
            contentview=itemView.findViewById(R.id.Content);

        }
    }
}
