package com.redcells;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
ImageButton imageButton;
RelativeLayout coordinatorLayout;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        coordinatorLayout=findViewById(R.id.activity_home);

        Snackbar.make(coordinatorLayout, "Click LIVE & Check out the latest news from India and around the world.", Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setDuration(10000)
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .show();


        ImageView add= findViewById(R.id.imageView);
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });
        ImageView search= findViewById(R.id.imageView2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,MainActivity.class));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,searchview.class));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.signout:
                so();
                break;

            case R.id.pp:

                break;



        }
        return super.onOptionsItemSelected(item);
    }
    public void so(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), OTP.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//makesure user cant go back
        startActivity(intent);



    }

    public void policy(MenuItem item) {

        Intent i = new Intent(getApplicationContext(),policy.class);
        startActivity(i);
    }
}
