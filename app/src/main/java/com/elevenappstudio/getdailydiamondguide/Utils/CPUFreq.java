package com.elevenappstudio.getdailydiamondguide.Utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CPUFreq {
    private static final String CPU_FREQ_PATH = "/sys/devices/system/cpu/cpu";
    private static final String FREQ_CURRENT = "/cpufreq/scaling_cur_freq";
    private static final String FREQ_MAX = "/cpufreq/cpuinfo_max_freq";
    private static final int UPDATE_INTERVAL_MS = 1000;
    
    public CPUUsageCallback callback;
    
    public Handler handler;
    
    public boolean isMonitoring = false;
    private Runnable monitorRunnable = new Runnable() {
        @Override
        public void run() {
            if (CPUFreq.this.isMonitoring) {
                List access$100 = CPUFreq.this.getCPUUsages();
                int access$200 = CPUFreq.this.calculateAverageUsage(access$100);
                if (CPUFreq.this.callback != null) {
                    CPUFreq.this.callback.onUsageUpdate(access$200, access$100);
                }
                CPUFreq.this.handler.postDelayed(this, 1000);
            }
        }
    };

    public interface CPUUsageCallback {
        void onUsageUpdate(int i, List<Double> list);
    }

    public CPUFreq(CPUUsageCallback cPUUsageCallback) {
        this.callback = cPUUsageCallback;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void startMonitoring() {
        if (!this.isMonitoring) {
            this.isMonitoring = true;
            this.handler.post(this.monitorRunnable);
        }
    }

    public void stopMonitoring() {
        this.isMonitoring = false;
        this.handler.removeCallbacks(this.monitorRunnable);
    }

    
    public List<Double> getCPUUsages() {
        ArrayList arrayList = new ArrayList();
        int numCores = getNumCores();
        for (int i = 0; i < numCores; i++) {
            long readFrequencyFromFile = readFrequencyFromFile(CPU_FREQ_PATH + i + FREQ_CURRENT);
            long readFrequencyFromFile2 = readFrequencyFromFile(CPU_FREQ_PATH + i + FREQ_MAX);
            if (readFrequencyFromFile2 > 0) {
                arrayList.add(Double.valueOf((((double) readFrequencyFromFile) / ((double) readFrequencyFromFile2)) * 100.0d));
            }
        }
        return arrayList;
    }

    
    public int calculateAverageUsage(List<Double> list) {
        if (list.isEmpty()) {
            return 0;
        }
        double d = 0.0d;
        for (Double doubleValue : list) {
            d += doubleValue.doubleValue();
        }
        return (int) Math.round(d / ((double) list.size()));
    }

    private long readFrequencyFromFile(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine.trim());
                bufferedReader.close();
                return parseLong;
            }
            bufferedReader.close();
            return 0;
        } catch (IOException | NumberFormatException e) {
            Log.d("shivam", e.getMessage());
            return 0;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return 0;
    }

    private int getNumCores() {
        return Runtime.getRuntime().availableProcessors();
    }
}
