package com.will.downsyndromeui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button login ;
    Button signUp ;

    public static final String CODE = "en";
    public static final String SHARED_CODE = "sharedcode";
    private String codeval ;

    @Override
    protected void onRestart() {
        super.onRestart();
       LoadData();
       setAppLocale(codeval);
       recreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
        setAppLocale(codeval);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LoadData();
        setAppLocale(codeval);



    }



    public void LoadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_CODE , MODE_PRIVATE);
        codeval = sharedPreferences.getString(CODE , "en");



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadData();
        setAppLocale(codeval);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER,
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER);






        signUp = (Button) findViewById(R.id.Register);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this , FlashCards.class);
                startActivity(a);


            }
        });


         login  = (Button)findViewById(R.id.Login);

         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                Intent a = new Intent(MainActivity.this , Settings.class);

                startActivity(a);

             }
         });





    }





    private void setAppLocale(String LoCoded){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        config.setLocale(new Locale(LoCoded.toLowerCase()));

        res.updateConfiguration(config,dm);


    }





}
