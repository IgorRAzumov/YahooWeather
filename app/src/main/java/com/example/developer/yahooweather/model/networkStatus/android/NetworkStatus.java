package com.example.developer.yahooweather.model.networkStatus.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.developer.yahooweather.App;
import com.example.developer.yahooweather.model.networkStatus.INetworkStatus;


public class NetworkStatus implements INetworkStatus {
    private NetworkStatus.Status currentStatus = NetworkStatus.Status.OFFLINE;

    private void getStatus() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                currentStatus = NetworkStatus.Status.WIFI;
            }

            if (activeNetwork.getType() == ConnectivityManager.TYPE_ETHERNET) {
                currentStatus = NetworkStatus.Status.ETHERNET;
            }

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                currentStatus = NetworkStatus.Status.MOBILE;
            }
        } else {
            currentStatus = NetworkStatus.Status.OFFLINE;
        }
    }

    @Override
    public boolean isOnline() {
        getStatus();
        return currentStatus.equals(NetworkStatus.Status.WIFI) ||
                currentStatus.equals(NetworkStatus.Status.MOBILE) ||
                currentStatus.equals(NetworkStatus.Status.ETHERNET);
    }

    public enum Status {
        WIFI,
        MOBILE,
        ETHERNET,
        OFFLINE
    }
}
