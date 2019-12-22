package com.redcells;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText otp,code,sms;
    String verificationId;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        mAuth = FirebaseAuth.getInstance();
        otp = findViewById(R.id.phnum);
        code = findViewById(R.id.code);
        send = findViewById(R.id.send);
        sms = findViewById(R.id.otpd);

        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            Intent i = new Intent(getApplicationContext(),Home.class);

            startActivity(i);

        }
        code.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {

                if(code.getText().toString().length()==2)
                {
                    otp.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {


            }

            public void afterTextChanged(Editable s) {

            }

        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = otp.getText().toString().trim();
                String cc = code.getText().toString().trim();
                if ((number.isEmpty()) || number.length() < 10  ) {
                    otp.setError("Valid number is required");
                    otp.requestFocus();
                    return;

                }
                else if(cc.isEmpty() || cc.length()<2){
                    code.setError("Vaild Code required");
                    code.requestFocus();
                    return;
                }

                final String phoneNumber = "+" + "91" + number;
                sendVerificationCode(phoneNumber);
            }
        });

    }


    private  void sendVerificationCode( String phoneNumber){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                this,
                mCallBack);
    }

    private  PhoneAuthProvider.OnVerificationStateChangedCallbacks

            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            Toast.makeText(OTP.this,"CODE SENT! Please wait while we Auto-detect your OTP.",Toast.LENGTH_LONG).show();

            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();
            if(code!=null){
                sms.setText(code);
                verifyCode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    };

    private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);
        signInWithCredential(credential);

    }

    private void signInWithCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(getApplicationContext(),Home.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });



    }}



