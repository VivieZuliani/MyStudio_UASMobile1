package com.example.mystudio;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CountActivity extends AppCompatActivity {
    private TextView show_count;
    private int count = 1;
    private long fibNMinus1 = 1;
    private long fibNMinus2 = 1;
    private int limit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        show_count = findViewById(R.id.show_count);
    }

    public void countUp(View view){
        if (count == 0){
            show_count.setText("0");
        }
        else if (count == 1){
            show_count.setText("1");
        }
        else {
            if (limit != -1 && count > limit){
                count = 0;
                fibNMinus1 = 1;
                fibNMinus2 = 0;
                show_count.setText("1");
            }
            else {
                long fibCurrent = fibNMinus1 +fibNMinus2;
                fibNMinus2 = fibNMinus1;
                fibNMinus1 = fibCurrent;

                int colorResId = R.color.colorAccent;
                switch (count % 11) {
                    case 1:
                        colorResId = R.color.bluu;
                        break;
                    case 2:
                        colorResId = R.color.reddish;
                        break;
                    case 3:
                        colorResId = R.color.hijau1;
                        break;
                    case 4:
                        colorResId = R.color.coklat;
                        break;
                    case 5:
                        colorResId = R.color.bluu2;
                        break;
                    case 6:
                        colorResId = R.color.aqua;
                        break;
                    case 7:
                        colorResId = R.color.merah;
                        break;
                    case 8:
                        colorResId = R.color.hijau2;
                        break;
                    case 9:
                        colorResId = R.color.reddish;
                        break;
                    case 10:
                        colorResId = R.color.blue;
                        break;
                    case 11:
                        colorResId = R.color.coklat;
                        break;
                    case 12:
                        colorResId = R.color.black;
                }
                show_count.setTextColor(getResources().getColor(colorResId));
                show_count.setText(String.valueOf(fibCurrent));
            }
        }
        count++;
    }

    public void back1(View view){
        count = 1;
        fibNMinus1 = 1;
        fibNMinus2 = 0;
        show_count.setText("1");
    }

    public void setLimit(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Limit");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String limitStr = input.getText().toString();
                limit = Integer.parseInt(limitStr);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
