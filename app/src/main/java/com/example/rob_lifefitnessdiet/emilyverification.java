package com.example.rob_lifefitnessdiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
public class emilyverification extends AppCompatActivity {
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emilyverification);
        auth=FirebaseAuth.getInstance();







         final TextView logoutbtn=findViewById(R.id.logoutbtn);
         logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login.class));

            }
        });
        final TextView verifytextview=findViewById(R.id.verifyemailtextview);
        final TextView verify=findViewById(R.id.verify);

        verifytextview.findViewById(R.id.verifyemailtextview);
        verify.findViewById(R.id.verify);



        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(emilyverification.this, "Mail has been sent on your Registered email address", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()){
            startActivity(new Intent(emilyverification.this,MainActivity.class));
        }


    }
}