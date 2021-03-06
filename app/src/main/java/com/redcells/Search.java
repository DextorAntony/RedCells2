package com.redcells;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private final ArrayList<String> result=new ArrayList<>();
    private final ArrayList<String> mylist=new ArrayList<>();
    private int flag=1;
    private String phone2;
    private static final int PERMS_REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();

        final String bloodgroup=getIntent().getStringExtra("bt");
        final String pancht=getIntent().getStringExtra("pa");
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference mRef = database.getReference("users/"+bloodgroup);
        ListView resultview = findViewById(R.id.listview);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, result);
        resultview.setAdapter(arrayAdapter);
        resultview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = parent.getPositionForView(view);
                String na = mylist.get(pos * 3);

                String pan = mylist.get((pos * 3) + 2);
                final String ph = mylist.get((pos * 3) + 1);
                phone2=ph;
                String item = Integer.toString(pos);

                Toast.makeText(Search.this, "Phone : " + phone2 + " City: " + pan, Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(Search.this);


                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.details);
                dialog.setTitle("Call Donor");
                //adding text dynamically
                TextView t1 = dialog.findViewById(R.id.textView5);
                TextView t2 = dialog.findViewById(R.id.textView6);
                TextView t3 = dialog.findViewById(R.id.textView7);
                TextView t4 = dialog.findViewById(R.id.textView8);

                t1.setText(na);
                t2.setText("Blood Type : "+bloodgroup);
                t3.setText("Phone : " + ph);
                t4.setText("Location: " + pan);
                //adding button click event
                Button call = dialog.findViewById(R.id.callbutt);
                Button cancel = dialog.findViewById(R.id.cancelbutt);
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (hasPermissions()) {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+ph));

                            if (ActivityCompat.checkSelfPermission(getBaseContext(),
                                    android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                                return;
                            }
                            startActivity(callIntent);
                        } else {
                            //Since our app doesn't have permission, we have to request one.
                            requestPerms();
                        }
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }

        });

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getValue()==null)
                {
                    Toast.makeText(Search.this,"No users found", Toast.LENGTH_SHORT).show();
                    finish();

                }
                String value = dataSnapshot.getValue(String.class);
                assert value != null;
                String[] val = value.split(",");

                if (val[2].equals(pancht)) {
                    flag=0;
                    mylist.add(val[0]);
                    mylist.add(val[1]);
                    mylist.add(val[2]);
                    result.add(val[0]);
                    arrayAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    private boolean hasPermissions(){
        int res = 0;

        String[] permissions = new String[]{Manifest.permission.CALL_PHONE};

        for (String perms : permissions){
            res = checkCallingOrSelfPermission(perms);
            if (!(res == PackageManager.PERMISSION_GRANTED)){
                return false;
            }
        }
        return true;
    }
    private void requestPerms(){
        String[] permissions = new String[]{Manifest.permission.CALL_PHONE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(permissions,PERMS_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean allowed = true;

        if (requestCode == PERMS_REQUEST_CODE) {
            for (int res : grantResults) {

                allowed = allowed && (res == PackageManager.PERMISSION_GRANTED);
            }
        } else {
            allowed = false;
        }

        if (allowed){

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+phone2));

            if (ActivityCompat.checkSelfPermission(getBaseContext(),
                    android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            startActivity(callIntent);
        }


    }


}



