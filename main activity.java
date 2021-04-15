package com.pashatabbed.firebasedatabaseformubashir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText edtemail,emailpassword;

    Button btnSignUp;


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mAuth = FirebaseAuth.getInstance();

        edtemail = findViewById(R.id.edtemailforSignUp);
        emailpassword = findViewById(R.id.edtPasswordforSignUp);


        btnSignUp  = findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignUp();
            }
        });


    }

    private void SignUp(){


        String email = edtemail.getText().toString();
        String password = emailpassword.getText().toString();


        if (email.equals("")||password.equals("")){
            Toast.makeText(this, "Plz enter all your Fields", Toast.LENGTH_SHORT).show();
        }else {


            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "There is some error", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}
