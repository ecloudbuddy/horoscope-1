package ac.kotlintest.until

import android.content.Context
import android.net.ConnectivityManager

open class UntilH {

     fun isConnect(context: Context) : Boolean {
        val cm : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }


}
