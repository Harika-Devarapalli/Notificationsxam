package com.example.notifications;

import static com.example.notifications.NotificationChannels.CHANNEL_1_ID;
import static com.example.notifications.NotificationChannels.CHANNEL_2_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.Notification.MediaStyle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.*;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText title, desc;
    Button c1, c2, c3, c4, c5;
    private static int id = 0;
    NotificationManagerCompat manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = NotificationManagerCompat.from(getApplicationContext());
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        c1 = findViewById(R.id.channel1);
        c2 = findViewById(R.id.channel2);
        c3 = findViewById(R.id.channel3);
        c4 = findViewById(R.id.channel4);
        c5 = findViewById(R.id.channel5);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_airport)
                        .setContentTitle(title.getText().toString())
                        .setContentText(desc.getText().toString())
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                manager.notify(id++, notification);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.ic_tractor)
                        .setContentTitle(title.getText().toString())
                        .setContentText(desc.getText().toString())
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                manager.notify(id++, notification);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap large = BitmapFactory.decodeResource(getResources(), R.drawable.large);
                Bitmap small = BitmapFactory.decodeResource(getResources(),R.drawable.small);
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_airport)
                        .setContentTitle(title.getText().toString())
                        .setContentText(desc.getText().toString())
                        .setLargeIcon(small)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(large)
                                .bigLargeIcon(null))
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                manager.notify(id++, notification);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap large = BitmapFactory.decodeResource(getResources(), R.drawable.large);
                Bitmap small = BitmapFactory.decodeResource(getResources(),R.drawable.small);

                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.ic_tractor)
                        .setContentTitle(title.getText().toString())
                        .setLargeIcon(small)
                        .setContentText(desc.getText().toString())
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .addAction(R.drawable.ic_dislike,"dislike",null)
                        .addAction(R.drawable.ic_previous,"previous",null)
                        .addAction(R.drawable.ic_pause,"pause",null)
                        .addAction(R.drawable.ic_next,"next",null)
                        .addAction(R.drawable.ic_like,"like",null)
                        .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                            .setShowActionsInCompactView(1,2,3))
                        .setSubText("Playing now")
                        .build();
                manager.notify(id++, notification);
            }
        });

    }
}