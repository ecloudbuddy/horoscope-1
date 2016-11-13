package ac.kotlintest.view.widjets

import ac.kotlintest.R
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import android.widget.Toast

class Widjet : AppWidgetProvider() {

    fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.new_app_widget)
        views.setTextViewText(R.id.appwidget_text, "kotlins")

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetIds in appWidgetIds){
            updateAppWidget(context, appWidgetManager, appWidgetIds)
        }
    }

    override fun onEnabled(context: Context) {
        Toast.makeText(context, "onEnabled", Toast.LENGTH_SHORT).show();
    }

    override fun onDisabled(context: Context){
        Toast.makeText(context, "onDisabled", Toast.LENGTH_SHORT).show();
    }

}


