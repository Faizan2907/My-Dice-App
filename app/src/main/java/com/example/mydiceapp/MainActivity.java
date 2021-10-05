package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.rolldice);

        ImageView dice1 = findViewById(R.id.dice1);
        ImageView dice2 = findViewById(R.id.dice2);

        TextView sum = findViewById(R.id.sum);
        TextView sum1 = findViewById(R.id.sum2);

        MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.dice_sound);

        btn.setOnClickListener(new View.OnClickListener() {
            int count = 0, count1 = 0;

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                int[] array_Image = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

                Random random = new Random();
                int random_no = random.nextInt(5);
                count = count + random_no + 1;
                sum.setText(String.valueOf(count));


                dice1.setImageResource(array_Image[random_no]);


                random_no = random.nextInt(5);
                count1 = count1 + random_no + 1;
                sum1.setText(String.valueOf(count1));
                dice2.setImageResource(array_Image[random_no]);
                sum1.setText(String.valueOf(count1));

//                if (count >= 50 && count1 >=50){
//                    Toast.makeText(getApplicationContext(), "Match has been Tie", Toast.LENGTH_SHORT).show();
//                }

                if (count >= 50){
                    Toast.makeText(getApplicationContext(), "Player A Has Won the match", Toast.LENGTH_SHORT).show();
                    sum.setText("");
                    sum1.setText("");
                    count = 0;
                    count1 = 0;
                }
                else if (count1 >= 50){
                    Toast.makeText(getApplicationContext(), "Player B Has Won the match", Toast.LENGTH_SHORT).show();
                    sum.setText("");
                    sum1.setText("");
                    count = 0;
                    count1 = 0;
                }

//                else if(count==50 && count1==50){
//                    Toast.makeText(getApplicationContext(), "Match hass been tie", Toast.LENGTH_SHORT).show();
//                }

                media.start();

                YoYo.with(Techniques.Shake)
                        .duration(300)
                        .repeat(1)
                        .playOn(dice1);

                YoYo.with(Techniques.Shake)
                        .duration(300)
                        .repeat(1)
                        .playOn(dice2);
            }
        });
    }
}