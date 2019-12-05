package com.hilaylotan.golfrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_HOLE1 = "key_hole1";
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
