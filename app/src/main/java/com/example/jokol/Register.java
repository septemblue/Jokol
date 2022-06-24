package com.example.jokol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jokol.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://moviedb-a8d94-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        binding.registerBtn.setOnClickListener(it -> {

            String email = binding.registerEmail.getText().toString();
            String password = binding.registerPassword.getText().toString();
            String phone = binding.registerPhone.getText().toString();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d("User", "createUserWithEmail:success");
                    }else {
                        Log.w("User", "createUserWithEmail:failure", task.getException());
                    }
                }
            });

            FirebaseUser user = mAuth.getCurrentUser();

            databaseReference.child("accounts").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(user.getUid())) {
                        Toast.makeText(Register.this, "User has already exist", Toast.LENGTH_SHORT).show();
                    } else {
                        databaseReference.child("accounts").child(user.getUid()).child("email").setValue(user.getEmail());
                        databaseReference.child("accounts").child(user.getUid()).child("password").setValue(password);
                        databaseReference.child("accounts").child(user.getUid()).child("phone").setValue(phone);

                        Toast.makeText(Register.this, "User Registered  successfully", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });


        binding.loginRedirect.setOnClickListener(it -> {
            finish();
        });
    }
}