package it.elhawy.sandinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView teUsername,tePassword,teDebug;
    RadioGroup rgLoginAs;
    CheckBox ckrememberme;
    String username,password;
    int rememberme=0,loginAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin = (Button) findViewById(R.id.btnLogin);
        tePassword = findViewById(R.id.teUsername);
        teUsername = findViewById(R.id.teUsername);
        teDebug = findViewById(R.id.teDebug);
        rgLoginAs = findViewById(R.id.rgLoginAs);
        ckrememberme = findViewById(R.id.ckrememberme);


        ckrememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ckrememberme.isChecked()){
                    rememberme = 1;
                }else{
                    rememberme = 0;
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = teUsername.getText().toString();
                password = tePassword.getText().toString();
                loginAS = rgLoginAs.getCheckedRadioButtonId();
                if(loginAS == R.id.rdAdmin){
                    loginAS = 1;
                }else{
                    loginAS = 0;
                }

                if(username.equals("")){
                    teDebug.setText("ERROR : username is required");
                }else if(password.equals("")){
                    teDebug.setText("ERROR : password is required");
                }else{
                    Intent controlPanel = new Intent(getBaseContext(),ControlPanel.class);
                    controlPanel.putExtra("loginAs",loginAS);
                    controlPanel.putExtra("username",username);
                    controlPanel.putExtra("password",password);

                    controlPanel.putExtra("rememberme",rememberme);
                    startActivity(controlPanel);
                }
                //teDebug.setText(username+"   |  "+password+"    |   "+loginAS+"  |  "+rememberme);

            }
        });




    }




}
