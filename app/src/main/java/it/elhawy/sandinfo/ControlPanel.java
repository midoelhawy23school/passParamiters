package it.elhawy.sandinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class ControlPanel extends AppCompatActivity {
    TextView teTitle,teWelcome;
    int loginAs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_panel);

        Intent intent = getIntent();
        String UserName = intent.getStringExtra("username");
        String Password = intent.getStringExtra("password");

        loginAs = intent.getIntExtra("loginAs",0);

        teTitle = findViewById(R.id.teTitle);
        teWelcome =  findViewById(R.id.teWelcome);
        if(loginAs == 0){
            teTitle.setText("User Panel");
        }else{
            teTitle.setText("Admin Panel");
        }



        teWelcome.setText( " Welcome Back dear " + UserName);

    }





}
