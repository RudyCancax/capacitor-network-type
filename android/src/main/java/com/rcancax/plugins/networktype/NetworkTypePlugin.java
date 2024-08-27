package com.rcancax.plugins.networktype;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "NetworkType")
public class NetworkTypePlugin extends Plugin {

    @PluginMethod
    @RequiresPermission(value = "android.permission.READ_PHONE_STATE")
    public void getNetworkType(PluginCall call) {
        // Initialize ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);

        String networkClass = "Unknown";
        boolean isWiFi = false;

        // Check if connected to WiFi
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                isWiFi = true;
            }
        }

        // If connected to mobile network
        if (!isWiFi) {
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_LTE:
                    networkClass = "4G";
                    break;
                case TelephonyManager.NETWORK_TYPE_NR:
                    networkClass = "5G";
                    break;
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    networkClass = "3G";
                    break;
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    networkClass = "2G";
                    break;
                default:
                    networkClass = "Below 2G";
            }
        } else {
            networkClass = "WiFi";
        }

        JSObject result = new JSObject();
        result.put("networkType", networkClass);
        result.put("isWiFi", isWiFi);
        call.resolve(result);
    }
}
