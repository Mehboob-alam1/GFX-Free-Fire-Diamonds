package com.elevenappstudio.getdailydiamondguide.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Choreographer;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.elevenappstudio.getdailydiamondguide.MainTabsActivity;
import com.elevenappstudio.getdailydiamondguide.R;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class NotificationService extends Service {
    private static final String CHANNEL_ID = "LatencyMonitor";
    private static final String HOST_TO_PING = "8.8.8.8";
    private static final int NOTIFICATION_ID = 1;
    private static final int PING_INTERVAL = 1000;
    private static final String STOP_ACTION = "STOP_SERVICE";
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Choreographer.FrameCallback frameCallback = new FPSFrameCallback();
    
    public int frameCount = 0;
    
    public final AtomicBoolean isMonitoring = new AtomicBoolean(true);
    
    public final Handler mainHandler = new Handler(Looper.getMainLooper());
    private NotificationCompat.Builder notificationBuilder;
    private RemoteViews notificationLayout;
    private RemoteViews notificationLayoutExpanded;
    private NotificationManager notificationManager;
    
    public long startTime = 0;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    static int access$108(NotificationService notificationService) {
        int i = notificationService.frameCount;
        notificationService.frameCount = i + 1;
        return i;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeNotification();
        startMonitoring();
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || !STOP_ACTION.equals(intent.getAction())) {
            return Service.START_STICKY;
        }
        stopSelf();
        return Service.START_NOT_STICKY;
    }

    private void initializeNotification() {
        createNotificationChannel();
        setupNotificationViews();
        startForegroundService();
    }

    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Analytics Monitor", 2);
        notificationChannel.setDescription("Shows real-time internet latency");
        notificationChannel.setShowBadge(false);
        NotificationManager notificationManager2 = (NotificationManager) getSystemService(NotificationManager.class);
        this.notificationManager = notificationManager2;
        notificationManager2.createNotificationChannel(notificationChannel);
    }

    private void setupNotificationViews() {
        this.notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_layout);
        this.notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.notification_layout);
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, MainTabsActivity.class), PendingIntent.FLAG_IMMUTABLE);
        this.notificationBuilder = new NotificationCompat.Builder((Context) this, CHANNEL_ID).setSmallIcon(R.drawable.logo).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setCustomContentView(this.notificationLayout).setCustomBigContentView(this.notificationLayoutExpanded).setPriority(-1).setOngoing(true).setForegroundServiceBehavior(1).setSilent(true).setContentIntent(activity).addAction(17301560, "Stop", PendingIntent.getService(this, 0, new Intent(this, NotificationService.class).setAction(STOP_ACTION), PendingIntent.FLAG_IMMUTABLE)).setOnlyAlertOnce(true);
        if (this.notificationManager == null) {
            this.notificationManager = (NotificationManager) getSystemService("notification");
        }
    }

    private void startForegroundService() {
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(1, this.notificationBuilder.build());
        } else {
            startForeground(1, this.notificationBuilder.build());
        }
    }

    private void startMonitoring() {
        startLatencyMonitoring();
        startFPSMonitoring();
    }

    private void startLatencyMonitoring() {
        this.executorService.execute(new Runnable() {
            @Override
            public void run() {
                runCall2();
            }
        });
    }


    public void runCall2() {
        while (this.isMonitoring.get()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                boolean isReachable = InetAddress.getByName(HOST_TO_PING).isReachable(2000);
                this.mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        runCall1(System.currentTimeMillis() - currentTimeMillis, isReachable);
                    }
                });
                Thread.sleep(1000);
            } catch (UnknownHostException unused) {
                updateErrorStatus("Unknown host error");
            } catch (IOException unused2) {
                updateErrorStatus("Network error");
            } catch (InterruptedException unused3) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private void startFPSMonitoring() {
        this.startTime = System.currentTimeMillis();
        this.frameCount = 0;
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    private class FPSFrameCallback implements Choreographer.FrameCallback {
        private FPSFrameCallback() {
        }

        @Override
        public void doFrame(long j) {
            NotificationService.access$108(NotificationService.this);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - NotificationService.this.startTime >= 1000) {
                int access$100 = NotificationService.this.frameCount;
                int unused = NotificationService.this.frameCount = 0;
                long unused2 = NotificationService.this.startTime = currentTimeMillis;
                NotificationService.this.mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        NotificationService.this.updateNotificationWithMetrics(access$100);
                    }
                });
                
                
            }
            if (NotificationService.this.isMonitoring.get()) {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
        
    }

    
    
    public void runCall1(long j, boolean z) {
        String str = z ? j + "ms" : "Unreachable";
        this.notificationLayout.setTextViewText(R.id.latencyView, str);
        this.notificationLayoutExpanded.setTextViewText(R.id.latencyView, str);
        updateNotification();
    }

    
    public void updateNotificationWithMetrics(int i) {
        this.notificationLayout.setTextViewText(R.id.fpsView, i + " FPS");
        this.notificationLayoutExpanded.setTextViewText(R.id.fpsView, i + " FPS");
        updateNotification();
    }

    private void updateErrorStatus(String str) {
        this.mainHandler.post(new Runnable() {
            @Override
            public void run() {
                runCall3(str);
            }
        });
    }

    

    public void runCall3(String str) {
        this.notificationLayout.setTextViewText(R.id.latencyView, str);
        this.notificationLayoutExpanded.setTextViewText(R.id.latencyView, str);
        updateNotification();
    }

    private void updateNotification() {
        this.notificationManager.notify(1, this.notificationBuilder.build());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.isMonitoring.set(false);
        this.executorService.shutdownNow();
        this.mainHandler.removeCallbacksAndMessages((Object) null);
        stopForeground(true);
        this.notificationManager.cancel(1);
    }
}
