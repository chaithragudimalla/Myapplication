package com.sai.chaithra.jntucejlibrary;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.Random;

public class Alarm2 extends BroadcastReceiver {

    private static final String ADMIN_CHANNEL_ID ="admin_channel";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Reminder.....", Toast.LENGTH_LONG).show();

        createNotification(context);
    }



    public void createNotification(Context context){

        SharedPreferences book = PreferenceManager.getDefaultSharedPreferences(context);

        String book1 = book.getString("book2", "No Book");
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent intent = new Intent(context, Alarm_activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,0);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "101";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_MAX);

            //Configure Notification Channel
            notificationChannel.setDescription("Book Notifications");
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Book due date")
                .setAutoCancel(true)
                .setSound(defaultSound)
                .setContentText(book1+" is Due")
                .setContentIntent(pendingIntent)
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_MAX);


        notificationManager.notify(1, notificationBuilder.build());


    }

}
