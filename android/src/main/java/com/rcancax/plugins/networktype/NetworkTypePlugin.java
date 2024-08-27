package com.example.plugin.networktype;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "NetworkType")
public class NetworkTypePlugin extends Plugin {

    @PluginMethod
    public void getNetworkType(PluginCall call) {
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        int networkType = telephonyManager.getNetworkType();
        String networkClass = "Unknown";

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
                networkClass = "Unknown";
        }

        JSObject result = new JSObject();
        result.put("networkType", networkClass);
        call.resolve(result);
    }
}
