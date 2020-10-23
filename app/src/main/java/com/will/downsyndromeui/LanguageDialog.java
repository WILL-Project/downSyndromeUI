package com.will.downsyndromeui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class LanguageDialog extends AppCompatDialogFragment {


    RadioButton  rbChoice  ;
    RadioGroup rgLanguage ;

    String AreaCodec ;


    public static final String CODE = "en";
    public static final String SHARED_CODE = "sharedcode";
    private String codeval ;

    private LabguageDialogListener listner ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listner = (LabguageDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement languageDialogListner");

        }


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.layout_change_pass,null);
        rgLanguage = view.findViewById(R.id.rbLanguages);

        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int ij) {

                rbChoice =radioGroup.findViewById(ij);

                if (rbChoice.getId() == R.id.rbAfrikaans){

                    AreaCodec = "af";
                }else{

                    if (rbChoice.getId() == R.id.rbEnglish){

                        AreaCodec = "en";
                    }else{
                        AreaCodec = "en";
                    }
                }
            }
        });


        builder.setView(view)

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {




                        listner.applySettings(AreaCodec);




                    }
                });






    return builder.create();

    }


    public interface LabguageDialogListener{
        void applySettings(String aCode);

    }







}
