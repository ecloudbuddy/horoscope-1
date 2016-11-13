package ac.kotlintest.view.until

import android.content.Context
import android.net.ConnectivityManager

class Until{

    fun isConnect(context: Context) : Boolean {
        val cm : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

}
