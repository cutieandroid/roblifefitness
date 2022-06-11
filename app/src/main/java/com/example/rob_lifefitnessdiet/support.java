package com.example.rob_lifefitnessdiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class support extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        final EditText msgcontent=findViewById(R.id.messagecontent);
        final Button sendbuttom=findViewById(R.id.sendbutton);

        sendbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlText=msgcontent.getText().toString();
                Toast.makeText(getApplicationContext(), urlText, Toast.LENGTH_SHORT).show();

                String addresses[]={"20102161.harshmali@gmail.com","pacmaninc.thegamester@gmail.com"};
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,addresses);
               // intent.putExtra(Intent.EXTRA_SUBJECT,"harshs subject");
                intent.putExtra(Intent.EXTRA_TEXT,urlText);
                if(intent.resolveActivity(getApplicationContext().getPackageManager())!=null)
                {
                    startActivity(intent);
                }

            }
        });
    }
}