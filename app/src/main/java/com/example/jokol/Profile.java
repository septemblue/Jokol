package com.example.jokol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jokol.databinding.ActivityProfileBinding;
import com.example.jokol.main.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    ActivityProfileBinding binding;
    FirebaseUser user;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://moviedb-a8d94-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        databaseReference.child("accounts").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(user.getUid())) {
                    String email = snapshot.child(user.getUid()).child("email").getValue(String.class);
                    String phone = snapshot.child(user.getUid()).child("phone").getValue(String.class);
                    String password = snapshot.child(user.getUid()).child("password").getValue(String.class);

                    binding.registerEmail.setText(email);
                    binding.registerPhone.setText(phone);
                    binding.registerPassword.setText(password);
                    binding.username.setText(user.getUid());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.ubahData.setOnClickListener(it -> {
            user.updateEmail(binding.registerEmail.getText().toString());
            user.updatePassword(binding.registerPassword.getText().toString());

            databaseReference.child("accounts").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    databaseReference.child("accounts").child(user.getUid()).child("email").setValue(binding.registerEmail.getText().toString());
                    databaseReference.child("accounts").child(user.getUid()).child("password").setValue(binding.registerPassword.getText().toString());
                    databaseReference.child("accounts").child(user.getUid()).child("phone").setValue(binding.registerPhone.getText().toString());
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            Toast.makeText(this, "DATA BERHASIL DIUBAH", Toast.LENGTH_SHORT).show();
        });

        binding.btmNav.setOnItemSelectedListener(it -> {
            if (it.getItemId() == R.id.ic_transaction) {
                startActivity(new Intent(Profile.this, TransactionPage.class));
                return true;
            } else if (it.getItemId() == R.id.ic_home) {
                startActivity(new Intent(Profile.this, MainActivity.class));
                return true;
            }
            return false;
        });

        binding.hapusAkun.setOnClickListener(it -> {
            databaseReference.child("accounts").child(user.getUid()).removeValue();
            user.delete();
            Toast.makeText(this, "DATA BERHASIL DIHAPUS", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Profile.this, Login.class));
        });

        binding.keluar.setOnClickListener(it -> {
            Toast.makeText(this, "TERIMAKASIH!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Profile.this, Login.class));
        });




    }
}