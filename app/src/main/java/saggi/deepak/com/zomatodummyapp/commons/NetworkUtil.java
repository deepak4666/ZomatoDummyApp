package saggi.deepak.com.zomatodummyapp.commons;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static saggi.deepak.com.zomatodummyapp.commons.Constants.TYPE_MOBILE;
import static saggi.deepak.com.zomatodummyapp.commons.Constants.TYPE_NOT_CONNECTED;
import static saggi.deepak.com.zomatodummyapp.commons.Constants.TYPE_NOT_FOUND;
import static saggi.deepak.com.zomatodummyapp.commons.Constants.TYPE_WIFI;
import static saggi.deepak.com.zomatodummyapp.commons.Constants.TYPE_WIMAX;


public class NetworkUtil {

    public NetworkUtil() {
    }

    public static NetworkUtil newInstance() {
        return new NetworkUtil();
    }

    /* Gets internet connectivity status and also pings to make sure it is available.
     *
     */
    public final String getInternetConnectionType(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork == null) {
            return "TYPE_NOT_FOUND";
        }

        int conn = activeNetwork.getType();
        int type = TYPE_NOT_FOUND;

        if (conn == TYPE_WIFI) {
            type = TYPE_WIFI;

        } else if (conn == TYPE_WIMAX) {
            type = TYPE_WIMAX;

        } else if (conn == TYPE_MOBILE) {
            type = TYPE_MOBILE;

        } else if (conn == TYPE_NOT_CONNECTED) {
            type = TYPE_NOT_CONNECTED;
        }

        boolean result = pingGoogle(context);

        if (!result) {
            return "TYPE_NOT_CONNECTED";
        }

        switch (type) {
            case TYPE_WIFI:
                return "TYPE_WIFI";
            case TYPE_WIMAX:
                return "TYPE_WIMAX";
            case TYPE_MOBILE:
                return "TYPE_MOBILE";
            case TYPE_NOT_CONNECTED:
                return "TYPE_NOT_CONNECTED";
            case TYPE_NOT_FOUND:
                return "TYPE_NOT_FOUND";
            default:
                return "TYPE_NOT_FOUND";
        }

    }

    public final boolean hasInternetConnection(Context context) {
        String type = getInternetConnectionType(context);

        switch (type) {
            case "TYPE_WIFI":
                return true;
            case "TYPE_WIMAX":
                return true;
            case "TYPE_MOBILE":
                return true;
            case "TYPE_NOT_CONNECTED":
                return false;
            case "TYPE_NOT_FOUND":
                return false;
            default:
                return false;
        }
    }

    private boolean pingGoogle(Context context) {
        int counter = 2;
        boolean result = false;

        if (isNetworkConnected(context)) {
            return true;
        } else {
            for (int i = 0; i < counter; i++) {
                result = isNetworkConnected(context);

                if (result) {
                    return true;
                } else {

                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                    }, 5000);
                }
            }
        }

        return false;
    }

    private boolean isNetworkConnected(Context context) {
        boolean connected = false;
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            final NetworkInfo[] netInfoAll = connectivityManager.getAllNetworkInfo();

            for (NetworkInfo network : netInfoAll) {
                System.out.println("get network type :::" + network.getTypeName());

                if ((network.getTypeName().equalsIgnoreCase("WIFI") || network.getTypeName().equalsIgnoreCase("MOBILE")) && network.isConnected() && network.isAvailable()) {
                    connected = true;
                    break;
                }
            }
        } else {
            return false;
        }
        final NetworkInfo newtWorkInfo = connectivityManager.getActiveNetworkInfo();
        if (newtWorkInfo != null && newtWorkInfo.isConnectedOrConnecting()) {
            connected = true;
        } else if (newtWorkInfo != null && newtWorkInfo.isConnected() && connectivityManager.getActiveNetworkInfo().isAvailable()) {
            connected = true;
        } else if (newtWorkInfo != null && newtWorkInfo.isConnected()) {
            try {
                URL url = new URL("http://www.google.com");
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setConnectTimeout(3000);
                urlc.connect();
                if (urlc.getResponseCode() == 200) {
                    connected = true;
                }
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return connected;
    }




}