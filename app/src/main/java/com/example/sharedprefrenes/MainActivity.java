package com.example.sharedprefrenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    // это будет именем файла настроек
    public static final String APP_PREFERENCES = "mysettings";

    public static final String APP_PREFERENCES_text = "text";

    SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        Button load = (Button) findViewById(R.id.button_save);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                String strText = editText.getText().toString();

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_text, strText);
                editor.apply();

            }
        });
        Button save = (Button) findViewById(R.id.button_load);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                editText.setText(mSettings.getString(APP_PREFERENCES_text, ""));
            }
        });


    }
//    public static SharedPreferences getDefaultSharedPreferences(Context context) {
//        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
//                getDefaultSharedPreferencesMode());
//    }
//
//    private static String getDefaultSharedPreferencesName(Context context) {
//        return context.getPackageName() + "_preferences";
//    }
//
//    private static int getDefaultSharedPreferencesMode() {
//        return Context.MODE_PRIVATE;
//    }




}