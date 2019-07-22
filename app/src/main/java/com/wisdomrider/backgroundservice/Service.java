package com.wisdomrider.backgroundservice;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;

import static com.wisdomrider.backgroundservice.Application.CHANNEL_ID;

public class Service extends android.app.Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "closed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show();
        Notification notification = new Notification.Builder(this, CHANNEL_ID)
                .setCustomContentView(new RemoteViews(getPackageName(),R.layout.doing_some_task))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .build();

        startForeground(1, notification);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
