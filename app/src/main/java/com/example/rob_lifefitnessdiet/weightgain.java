package com.example.rob_lifefitnessdiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class weightgain extends AppCompatActivity {

    Intent intent;
    String display;
    private RecyclerView recyclerViewweightgain;
    private ArrayList<imageandtextmodel> imageandtextmodelArrayList;
    private recyclerimageandtextadapter recyclerimageadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightgain);
        recyclerViewweightgain=findViewById(R.id.recylerviewweightgain);
        recyclerViewweightgain.setLayoutManager(new GridLayoutManager(weightgain.this,1) )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ;
        recyclerViewweightgain.setHasFixedSize(true);
        imageandtextmodelArrayList=new ArrayList<>();
        TextView bmidisplay=findViewById(R.id.bmidisplay);
        intent=getIntent();
        display=intent.getStringExtra("bmi");
        bmidisplay.setText(display);


        clearAll();
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("weightgain");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                clearAll();
                for(DataSnapshot snapshot: datasnapshot.getChildren()){
                    imageandtextmodel imageandtextmodel= new imageandtextmodel();
                    imageandtextmodel.setImageurl(snapshot.child("dietimage").getValue().toString());
                    imageandtextmodel.setHeader(snapshot.child("header").getValue().toString());
                    imageandtextmodel.setContentinfo(snapshot.child("string").getValue().toString());



                    // imagemodel = snapshot.getValue(imagemmodel.class);


                    imageandtextmodelArrayList.add(imageandtextmodel);
                }

                recyclerimageadapter= new recyclerimageandtextadapter(getApplicationContext(),imageandtextmodelArrayList);
                recyclerViewweightgain.setAdapter(recyclerimageadapter);
               recyclerimageadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(weightgain.this, "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void clearAll() {
        if(imageandtextmodelArrayList!=null)
        {
            imageandtextmodelArrayList.clear();

            if(recyclerimageadapter != null)
            {
                recyclerimageadapter.notifyDataSetChanged();
            }
        }
        imageandtextmodelArrayList=new ArrayList<>();



    }
}