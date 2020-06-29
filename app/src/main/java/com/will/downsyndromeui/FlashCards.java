package com.will.downsyndromeui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FlashCards extends AppCompatActivity {
    SpannableString sentanceone[] = new SpannableString[7];
    String sentanceNumber[] = new String[7];
    SpannableString sentanceExplained[] = new SpannableString[7];
    SpannableString sentanceLast[] = new SpannableString[7];
    String numberInWords[] ;
    int currentIndex = 0 ;

    TextView tvfirstSentce  , tvSecondSentance ,tvThirdSentace ;
    Button btnNext ;

    ForegroundColorSpan selectedText = new ForegroundColorSpan(Color.parseColor("#FE4331"));




    public String wordWithDash(String a){


        String Temp = "" ;

        for (int i = 0 ; i < a.length() ; i++){

            if(i == 0 ){

                Temp = a.charAt(i) + "" ;

            }else{

             Temp = Temp + "-" + a.charAt(i) ;

            }
        }


        return Temp ;


    }


    public void generateValues(){

        for(int i = 0 ; i  <7 ; i++){

            sentanceNumber[i] = (i+1) + "" ;

        }

        numberInWords = new String[]{"ONE",
                "TWO",
                "THREE",
                "FOUR",
                "FIVE",
                "SIX",
                "SEVEN"};


        String tempSentanceOne = "" ;


        for(int j =0 ; j < 7 ; j++){

            tempSentanceOne  = "This is the number " + sentanceNumber[j] + ".";

            sentanceone[j] = new SpannableString(tempSentanceOne);
            sentanceone[j].setSpan(selectedText , 19 , 19+sentanceNumber[j].length()  , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            tempSentanceOne = "It is spelt "+ wordWithDash(numberInWords[j]);

            sentanceExplained[j] = new SpannableString(tempSentanceOne);
            sentanceExplained[j].setSpan(selectedText ,12 , 12 + wordWithDash(numberInWords[j]).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

            tempSentanceOne = "Below is " + sentanceNumber[j] + " apples." ;

            sentanceLast[j] = new SpannableString(tempSentanceOne);
            sentanceLast[j].setSpan(selectedText , 9 , 9 +sentanceNumber[j].length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        generateValues();

        tvfirstSentce = findViewById(R.id.firstSentance);
        tvSecondSentance = findViewById(R.id.SecondSentance);
        tvThirdSentace = findViewById(R.id.ThirdSentance);
        btnNext = findViewById(R.id.nextBtn);




        tvfirstSentce.setText(sentanceone[0]);
        tvSecondSentance.setText(sentanceExplained[0]);
        tvThirdSentace.setText(sentanceLast[0]);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(currentIndex == 6 ){
                    currentIndex = 0 ;


                }else{

                    currentIndex ++ ;

                }

                tvfirstSentce.setText(sentanceone[currentIndex]);
                tvSecondSentance.setText(sentanceExplained[currentIndex]);
                tvThirdSentace.setText(sentanceLast[currentIndex]);


            }
        });















    }
}
