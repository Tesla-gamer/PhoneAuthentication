package com.example.dummy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
Button b1;
EditText t1;
CountryCodePicker ccp;
FirebaseAuth mAuth;
FirebaseUser muser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      t1=findViewById(R.id.t1);
      b1=findViewById(R.id.b1);
      ccp=findViewById(R.id.ccp);
      ccp.registerCarrierNumberEditText(t1);
      mAuth=FirebaseAuth.getInstance();

      b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,MainActivity2.class);
              intent.putExtra("mobile", ccp.getFullNumberWithPlus().replace(" ",""));
              startActivity(intent);
          }
      });

    }
    @Override
    protected void onStart() {
        super.onStart();
        muser = mAuth.getCurrentUser();
        if (muser != null) {
            Intent intent = new Intent(MainActivity.this, dashboard.class);
            startActivity(intent);
            finish();
        }
    }
}