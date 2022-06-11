package com.example.rob_lifefitnessdiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView emailaccount;


    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        //Assign Variables
        drawerLayout=findViewById(R.id.drawer_layout);
        emailaccount=findViewById(R.id.emailfieldnavigation);
        final ImageView bmitest=findViewById(R.id.fitnesstest);
        String currentusersemail=auth.getCurrentUser().getEmail();
        emailaccount.setText(currentusersemail);
        final FloatingActionButton suportactionbuton=findViewById(R.id.supportActionButton);

        /******************************redirect to bmi test activity***********************************/



       /* final TextView verifytextview=findViewById(R.id.verifyemailtextview);
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
        });*/


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

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        //close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //closedrawer layout
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);


        }

    }
    public void ClickHome(View view){
        //recreate activity
        recreate();

    }


    public void ClickWorkouts(View view){
        redirectActivity(this,workouts.class);


    }
    public void ClickDiet(View view){
        redirectActivity(this,nutritions.class);


    }
    public void ClickAboutUs(View view){
        redirectActivity(this,aboutus.class);


    }
    public void clicksupport(View view){
        redirectActivity(this,support.class);
    }

    public void redirectActivity(Activity activity,Class aclass) {
        Intent intent=new Intent (activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
    public void clickbmitest(View view){
        redirectActivity(this,bmitest.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}