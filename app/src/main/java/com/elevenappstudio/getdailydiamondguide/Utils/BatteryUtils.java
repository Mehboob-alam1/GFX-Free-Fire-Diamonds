package com.elevenappstudio.getdailydiamondguide.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class BatteryUtils {
    private BroadcastReceiver batteryReceiver;
    private Context context;
    
    public List<WeakReference<BatteryUpdateListener>> listeners = new ArrayList();
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    public interface BatteryUpdateListener {
        void onBatteryUpdate(String str, String str2, String str3, int i, int i2, int i3);
    }

    public BatteryUtils(Context context2) {
        this.context = context2;
        setupBatteryReceiver();
    }

    private void setupBatteryReceiver() {
        this.batteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    BatteryUtils.this.updateBatteryInfo();
                }
            }
        };
        this.context.registerReceiver(this.batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public void addBatteryUpdateListener(BatteryUpdateListener batteryUpdateListener) {
        this.listeners.add(new WeakReference(batteryUpdateListener));
    }

    public void removeBatteryUpdateListener(BatteryUpdateListener batteryUpdateListener) {
        for (WeakReference next : this.listeners) {
            if (next.get() == batteryUpdateListener) {
                this.listeners.remove(next);
                return;
            }
        }
    }

    
    public void updateBatteryInfo() {
        final String chargingStatus = getChargingStatus();
        final String estimatedTimeLeft = getEstimatedTimeLeft();
        final String powerSource = getPowerSource();
        this.mainHandler.post(new Runnable() {
            @Override
            public void run() {
                for (WeakReference weakReference : BatteryUtils.this.listeners) {
                    BatteryUpdateListener batteryUpdateListener = (BatteryUpdateListener) weakReference.get();
                    if (batteryUpdateListener != null) {
                        batteryUpdateListener.onBatteryUpdate(chargingStatus, estimatedTimeLeft, powerSource, BatteryUtils.this.getBatteryLevel(), BatteryUtils.this.getVoltage(), BatteryUtils.this.getTemperature());
                    }
                }
            }
        });
    }

    public void cleanup() {
        BroadcastReceiver broadcastReceiver = this.batteryReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
        this.listeners.clear();
    }

    public String getChargingStatus() {
        int intExtra = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == 2) {
            return "Charging";
        }
        if (intExtra == 3) {
            return "Discharging";
        }
        if (intExtra == 4) {
            return "Not charging";
        }
        if (intExtra != 5) {
            return "Unknown";
        }
        return "Full";
    }

    public String getEstimatedTimeLeft() {
        Intent registerReceiver = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1) == 2) {
            return "Charging";
        }
        int intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return "Unknown";
        }
        float f = ((float) intExtra) / ((float) intExtra2);
        long computeChargeTimeRemaining = ((BatteryManager) this.context.getSystemService("batterymanager")).computeChargeTimeRemaining();
        if (computeChargeTimeRemaining == -1) {
            computeChargeTimeRemaining = (long) (f * ((float) 86400000));
        }
        return String.format("%dh %dm", new Object[]{Long.valueOf(computeChargeTimeRemaining / 3600000), Long.valueOf((computeChargeTimeRemaining % 3600000) / 60000)});
    }

    public String getBatteryHealth() {
        switch (this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("health", -1)) {
            case 2:
                return "Good";
            case 3:
                return "Overheat";
            case 4:
                return "Dead";
            case 5:
                return "Over voltage";
            case 6:
                return "Unspecified failure";
            case 7:
                return "Cold";
            default:
                return "Unknown";
        }
    }

    public String getPowerSource() {
        int intExtra = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
        if (intExtra == 1) {
            return "AC";
        }
        if (intExtra == 2) {
            return "USB Port";
        }
        if (intExtra != 4) {
            return "Not plugged";
        }
        return "Wireless";
    }

    public int getVoltage() {
        return this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("voltage", -1);
    }

    public int getTemperature() {
        return (int) (((float) this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("temperature", -1)) / 10.0f);
    }

    public int getBatteryLevel() {
        Intent registerReceiver = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return (int) ((((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))) * 100.0f);
    }
}
