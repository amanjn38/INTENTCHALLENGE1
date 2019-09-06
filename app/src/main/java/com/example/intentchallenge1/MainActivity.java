package com.example.intentchallenge1;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivlocation,ivhappy,ivphone,ivweb;
    Button btnCreate;
    final int ACTIVITY2 = 1;
    String name="",number="",web="",location="",mood="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivhappy = findViewById(R.id.ivhappy);
        ivlocation = findViewById(R.id.ivlocation);
        ivweb = findViewById(R.id.ivweb);
        ivphone = findViewById(R.id.ivphone);
        btnCreate = findViewById(R.id.btnCreate);

        ivlocation.setVisibility(View.GONE);
        ivweb.setVisibility(View.GONE);
        ivhappy.setVisibility(View.GONE);
        ivphone.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.intentchallenge1.Activity2.class);
                startActivityForResult(intent, ACTIVITY2);

            }
        });

        ivphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intent);

            }
        });

        ivlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q=" + location));
                startActivity(intent);

            }
        });

        ivweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + web));
                startActivity(intent);

            }
        });
    }

        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==ACTIVITY2)
            {
                if (resultCode == RESULT_OK)
                {
                    ivlocation.setVisibility(View.VISIBLE);
                    ivweb.setVisibility(View.VISIBLE);
                    ivhappy.setVisibility(View.VISIBLE);
                    ivphone.setVisibility(View.VISIBLE);

                    name=data.getStringExtra("Name");
                    number=data.getStringExtra("Number");
                    web=data.getStringExtra("Web");
                    location=data.getStringExtra("Location");
                    mood=data.getStringExtra("Mood");

                    if(mood.equals("happy"))
                    {
                        ivhappy.setImageResource(R.drawable.happy);
                    }
                   else if(mood.equals("bad"))
                    {
                        ivhappy.setImageResource(R.drawable.bad);
                    }
                    else
                    {
                        ivhappy.setImageResource(R.drawable.emoji);
                    }

                }
                else
                {
                    Toast.makeText(this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

