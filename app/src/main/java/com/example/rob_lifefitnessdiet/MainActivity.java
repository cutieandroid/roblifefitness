package com.example.rob_lifefitnessdiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();

        final TextView verifytextview=findViewById(R.id.verifyemailtextview);
        final TextView verify=findViewById(R.id.verify);

        verifytextview.findViewById(R.id.verifyemailtextview);
        verify.findViewById(R.id.verify);

        if(!auth.getCurrentUser().isEmailVerified()){
            verifytextview.setVisibility(View.VISIBLE);
            verify.setVisibility(View.VISIBLE);
        }
        else {
            verifytextview.setVisibility(View.GONE);
            verify.setVisibility(View.GONE);
        }

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Mail has been sent on your Registered email address", Toast.LENGTH_SHORT).show();
                        if(auth.getCurrentUser().isEmailVerified()){
                            verifytextview.setVisibility(View.GONE);
                            verify.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });


        /*logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login.class));

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.logoutmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),login.class));

        }
        return super.onOptionsItemSelected(item);
    }
}