package com.coursera.agaidaichuk.lab5modernui;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar colorSeekBar;
    View col1row1;
    View col1row2;
    View col2row1;
    View col2row2;
    View col2row3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSeekBar = (SeekBar) findViewById(R.id.seekBar);
        col1row1 = findViewById(R.id.col1row1);
        col1row2 = findViewById(R.id.col1row2);
        col2row1 = findViewById(R.id.col2row1);
        col2row2 = findViewById(R.id.col2row2);
        col2row3 = findViewById(R.id.col2row3);

        colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackgroundColor(col1row1, progress);
                updateBackgroundColor(col1row2, progress);
                updateBackgroundColor(col2row1, progress);
                updateBackgroundColor(col2row3, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(this.getClass().getName(), "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i(this.getClass().getName(), "onStopTrackingTouch");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "More information");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == Menu.FIRST) {
            showDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {
        DialogFragment newFragment = MoreInfoAlertDialog.newInstance();
        newFragment.show(getFragmentManager(), "dialog");
    }

    private void updateBackgroundColor(View view, int progressChanged) {
        float[] hsvColor = new float[3];
        int originalColor = ((ColorDrawable) view.getBackground()).getColor();
        Color.colorToHSV(originalColor, hsvColor);
        hsvColor[0] = hsvColor[0] + (float) progressChanged / colorSeekBar.getMax();
        view.setBackgroundColor(Color.HSVToColor(Color.alpha(originalColor), hsvColor));
    }
}
