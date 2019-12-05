package com.hilaylotan.golfrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_HOLE1 = "key_hole1";
    private static final String PREFS_FILES = "com.hilaylotan.golfrecord.sharedprafrences";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView[] textHoleArry = new TextView[9];
    Button[] plusButtonArry = new Button[9];
    Button[] minusButtonArry = new Button[9];
    TextView[] textScoreArry = new TextView[9];
    int[] scoreArry = new int[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrysInit();

        sharedPreferences = getSharedPreferences(PREFS_FILES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        scoreArry[0]=sharedPreferences.getInt(KEY_HOLE1,0);
        textScoreArry[0].setText(String.valueOf(scoreArry[0]));

        plusButtonArry[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlusButtonClick(0);
            }
        });

        minusButtonArry[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MinusButtonClick(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem clearScoreButton = menu.add("Clear score");
        clearScoreButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                ClearScoreButtonClick();

                return true;
            }
        });

        return true;
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();

        editor.putInt(KEY_HOLE1,scoreArry[0]).apply();
    }

    private void ClearScoreButtonClick() {
        for (int i=0;i<scoreArry.length;i++)
        {
            scoreArry[i]=0;
            textScoreArry[0].setText(String.valueOf(scoreArry[i]));
        }
    }

    private void MinusButtonClick(int buttonNum) {
        if (scoreArry[buttonNum]>0){
            scoreArry[buttonNum]--;
            textScoreArry[buttonNum].setText(String.valueOf(scoreArry[buttonNum]));}
    }

    private void PlusButtonClick(int buttonNum) {
        if (scoreArry[buttonNum]>=0){
            scoreArry[buttonNum]++;
            textScoreArry[buttonNum].setText(String.valueOf(scoreArry[buttonNum]));}
    }

    private void ArrysInit() {
        textHoleArry[0]=findViewById(R.id.TextHole1);
        plusButtonArry[0]=findViewById(R.id.PluseButton1);
        minusButtonArry[0]=findViewById(R.id.MinusButton1);
        textScoreArry[0]=findViewById(R.id.TextScore1);
        scoreArry[0]=0;
    }
}
