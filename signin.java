package com.pashatabbed.firebasedatabaseformubashir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    EditText edtemail,emailpassword;

    Button btnSignUp;


    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        mAuth = FirebaseAuth.getInstance();

        edtemail = findViewById(R.id.edtemailforSignIn);
        emailpassword = findViewById(R.id.edtPasswordforSignIn);


        btnSignUp  = findViewById(R.id.btnSignIN);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignIn();
            }
        });
    }


    private void SignIn(){


        String email = edtemail.getText().toString();
        String password = emailpassword.getText().toString();


        if (email.equals("")||password.equals("")){
            Toast.makeText(this, "Plz enter all your Fields", Toast.LENGTH_SHORT).show();
        }else {


            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(SignIn.this, "SignIn Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                    }
                    else {
                        Toast.makeText(SignIn.this, "There is some error", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }




    public void Registation(View view) {

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
