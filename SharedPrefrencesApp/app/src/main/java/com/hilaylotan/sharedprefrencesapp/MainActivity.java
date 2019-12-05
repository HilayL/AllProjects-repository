package com.hilaylotan.sharedprefrencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.hilaylotan.sharedprefrencesapp.prefrences";
    private static final String KEY_EDITTEXT = "key_edittext";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editText = findViewById(R.id.editText);
        editor = sharedPreferences.edit();

        String editTextString = sharedPreferences.getString(KEY_EDITTEXT,"");
        editText.setText(editTextString);
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();

        editor.putString(KEY_EDITTEXT,editText.getText().toString());
        editor.apply();
    }
}
