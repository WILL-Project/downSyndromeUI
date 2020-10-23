package com.will.downsyndromeui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Settings extends AppCompatActivity implements LanguageDialog.LabguageDialogListener {


    Button chnageLanguagePreference ;
    public static final String CODE = "en";
    public static final String SHARED_CODE = "sharedcode";
    private String codeval ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_settings);
    chnageLanguagePreference = (Button) findViewById(R.id.btnChangeLanguage);

    chnageLanguagePreference.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            openDialog();


        }
    });


    }


    private void openDialog() {

        LanguageDialog lanDia = new LanguageDialog();
        lanDia.show(getSupportFragmentManager(),"Language Dialog");

    }


    private void setAppLocale(String LoCoded){



        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        config.setLocale(new Locale(LoCoded.toLowerCase()));
        res.updateConfiguration(config,dm);






    }


    public void savedata(String text){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_CODE , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CODE , text );


        editor.apply();



    }

    public void LoadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_CODE , MODE_PRIVATE);
        codeval = sharedPreferences.getString(CODE , "en");

        Toast.makeText(Settings.this, codeval + "   okay ", Toast.LENGTH_SHORT).show();

    }



    @Override
    public void applySettings(String aCode) {
        Toast.makeText(Settings.this, aCode, Toast.LENGTH_SHORT).show();

        setAppLocale(aCode);
        savedata(aCode);


        Intent intent = Settings.this.getIntent();
        Settings.this.finish();
        startActivity(intent);










    }
}