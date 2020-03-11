package com.edu.uac.co.grupo10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Color color;
    private Switch enDiSwitch;
    private EditText wSomText;
    private SeekBar inDeBar;
    private Button colButton, eButton;
    private LinearLayout colLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String colorArray[] = {"#5FFF2E", "#FFD700", "#FF2E4D", "#EBA91A", "#EFC5FF", "#B8FF70", "#FDB0BE"};

        enDiSwitch = (Switch) findViewById(R.id.enableDisableText);
        wSomText = (EditText) findViewById(R.id.writeSomething);
        inDeBar = (SeekBar) findViewById(R.id.inDecreaseBar);
        colButton = (Button) findViewById(R.id.changeColor);
        eButton = (Button) findViewById(R.id.exitButton);
        colLayout = (LinearLayout) findViewById(R.id.colorLayout);


        enDiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == false){
                    wSomText.setEnabled(false);
                    wSomText.setInputType(InputType.TYPE_NULL);
                }else{
                    wSomText.setEnabled(true);
                    wSomText.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        inDeBar.setOnSeekBarChangeListener(seekBarChangeListener);

        colButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int r = new Random().nextInt(7);
                colLayout.setBackgroundColor(Color.parseColor(colorArray[r]));
            }
        });

        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    public void openDialog() {
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.show(getSupportFragmentManager(),"exit dialog");
    }

}
