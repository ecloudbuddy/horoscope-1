package ac.kotlintest.view.adapters

import ac.kotlintest.R
import ac.kotlintest.model.pojo.HoroscopeItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import java.util.*

open class ChooseYourHorAdapter(context: Context, resource: Int, list: ArrayList<HoroscopeItem>) :
        ArrayAdapter<HoroscopeItem>(context, resource, list) {

    var resource: Int
    var list: ArrayList<HoroscopeItem>
    var vi: LayoutInflater

    init {
        this.list = list
        this.resource = resource
        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var holder: ViewHolder
        var retView: View
        var horoscopeItem: HoroscopeItem = list[position]

        if (convertView == null) {
            retView = vi.inflate(resource, null)
            holder = ViewHolder()

            holder.image = retView!!.findViewById(R.id.horoscope_image) as ImageView?

            retView.setTag(holder)
        } else {
            holder = convertView.tag as ViewHolder
            retView = convertView
        }

        var resImage: Int = context.resources.getIdentifier(horoscopeItem.nameImage, "drawable", context.packageName)
        holder.image!!.setImageResource(resImage)

        return retView
    }

    internal class ViewHolder {
        var image: ImageView? = null
    }

}
