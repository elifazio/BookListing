package br.com.clubedosaplicativos.booklisting.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import br.com.clubedosaplicativos.booklisting.R;

/**
 * Classe utilitária para trabalhar questões de comunicação com a internet.
 *
 * @author Elifazio Bernardes da Silva
 */
public class CommunicationUtil {

    public static final String TAG = CommunicationUtil.class.getSimpleName();
    // Whether there is a Wi-Fi connection.
    private static boolean wifiConnected = false;
    // Whether there is a mobile connection.
    private static boolean mobileConnected = false;

    /**
     * Check whether the device is connected, and if so, whether the connection is wifi or mobile
     * (it could be something else).
     */

    public static boolean checkNetworkConnection(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if (wifiConnected) {
                Log.i(TAG, context.getString(R.string.wifi_connection));
            } else if (mobileConnected) {
                Log.i(TAG, context.getString(R.string.mobile_connection));
            }
            return true;
        } else {
            Log.i(TAG, context.getString(R.string.no_wifi_or_mobile));
        }
        return false;
    }

    /**
     * Realiza a validação da conexão com a internet e exibe uma mensgaem padrão
     *
     * @param {@link Context} onde está realizando a validação
     * @return Verdadeiro se está conectado com a internet
     */

    public static boolean validateNetworkConnection(Context context) {
        if (!checkNetworkConnection(context)) {
            Toast.makeText(context, context.getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}