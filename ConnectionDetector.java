package *;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector 
{
	private Context _context;
    
    public ConnectionDetector(Context context){
        this._context = context;
    }
 
    public boolean isConnectingToInternet()
    {
        ConnectivityManager cm = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                Log.p("Internet WIFI");
                return true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Log.p("Internet DATA");
                return true;
            }
        }
        // not connected to the internet
        return false;
    }
}
