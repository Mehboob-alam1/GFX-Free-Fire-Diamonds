package com.elevenappstudio.getdailydiamondguide.Utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CPUUtils {
    private static final int COMPUTATION_ITERATIONS = 1000000;
    private static final int UPDATE_INTERVAL = 1000;
    private ActivityManager activityManager;
    private Context context;
    private double cpuUsage = 0.0d;
    
    public Handler handler;
    
    public boolean isMonitoring = false;
    
    public List<WeakReference<CpuUpdateListener>> listeners = new ArrayList();
    private Runnable updateRunnable = new Runnable() {
        @Override
        public void run() {
            int cPUUsage = (int) CPUUtils.this.getCPUUsage();
            int cpuTemperature = CPUUtils.this.getCpuTemperature();
            for (WeakReference weakReference : CPUUtils.this.listeners) {
                CpuUpdateListener cpuUpdateListener = (CpuUpdateListener) weakReference.get();
                if (cpuUpdateListener != null) {
                    cpuUpdateListener.onCpuUpdate(cPUUsage, cpuTemperature);
                }
            }
            if (CPUUtils.this.isMonitoring) {
                CPUUtils.this.handler.postDelayed(this, 1000);
            }
        }
    };

    public interface CpuUpdateListener {
        void onCpuUpdate(int i, int i2);
    }

    public CPUUtils(Context context2) {
        this.context = context2;
        this.handler = new Handler(Looper.getMainLooper());
        this.activityManager = (ActivityManager) context2.getSystemService("activity");
    }

    public void addCpuUpdateListener(CpuUpdateListener cpuUpdateListener) {
        this.listeners.add(new WeakReference(cpuUpdateListener));
        if (!this.isMonitoring) {
            startMonitoring();
        }
    }

    public void removeCpuUpdateListener(CpuUpdateListener cpuUpdateListener) {
        Iterator<WeakReference<CpuUpdateListener>> it = this.listeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference next = it.next();
            if (next.get() == cpuUpdateListener) {
                this.listeners.remove(next);
                break;
            }
        }
        if (this.listeners.isEmpty()) {
            stopMonitoring();
        }
    }

    private void startMonitoring() {
        this.isMonitoring = true;
        this.handler.post(this.updateRunnable);
    }

    private void stopMonitoring() {
        this.isMonitoring = false;
        this.handler.removeCallbacks(this.updateRunnable);
    }

    public float getCPUUsage() {
        return (float) (new Random().nextInt(61) + 30);
    }

    public int getCpuTemperature() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/class/thermal/thermal_zone0/temp"));
            float parseFloat = Float.parseFloat(bufferedReader.readLine()) / 1000.0f;
            bufferedReader.close();
            return (int) parseFloat;
        } catch (IOException e) {
            Log.d("shivam", e.getMessage());
            return 0;
        }
    }

    public void cleanup() {
        stopMonitoring();
        this.listeners.clear();
    }

    public int getCpuCoreCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    public long getCpuFrequency(int i) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq"));
            long parseLong = Long.parseLong(bufferedReader.readLine());
            bufferedReader.close();
            return parseLong;
        } catch (IOException e) {
            Log.e("CPUUtils", "Error reading CPU frequency for core " + i, e);
            return -1;
        }
    }

    public double getCpuFrequencyGHz(int i) {
        long cpuFrequency = getCpuFrequency(i);
        if (cpuFrequency == -1) {
            return -1.0d;
        }
        return ((double) cpuFrequency) / 1.0E9d;
    }

    public double getCpuFrequencyMHz(int i) {
        long cpuFrequency = getCpuFrequency(i);
        if (cpuFrequency == -1) {
            return -1.0d;
        }
        return ((double) cpuFrequency) / 1000000.0d;
    }

    public String getOverallCpuFrequencies() {
        int cpuCoreCount = getCpuCoreCount();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < cpuCoreCount; i++) {
            long cpuFrequency = getCpuFrequency(i);
            if (cpuFrequency != -1) {
                long j = cpuFrequency / 1000;
                hashMap.put(Long.valueOf(j), Integer.valueOf(((Integer) hashMap.getOrDefault(Long.valueOf(j), 0)).intValue() + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        /*for (Map.Entry entry : hashMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(entry.getValue()).append(" x ").append(String.format("%.2f GHz", new Object[]{Double.valueOf(((double) ((Long) entry.getKey()).longValue()) / 1000.0d)}));
        }*/
        return sb.toString();
    }
}
