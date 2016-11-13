package ac.kotlintest.view.activities

import ac.kotlintest.R
import ac.kotlintest.view.adapters.SettingsPagerAdapter
import ac.kotlintest.view.fragments.ChooseYourHoroscope
import ac.kotlintest.view.fragments.DailyHoroscopeFragment
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.renderscript.Allocation
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_horoscope_settings.*

internal class HoroscopeSettings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscope_settings)

        settingsViewPager(
                addSettingsFragmentToAdapter(ChooseYourHoroscope(), DailyHoroscopeFragment())
        )
    }

    //add fragments to adapter
    fun addSettingsFragmentToAdapter(welcomeFr: ChooseYourHoroscope,
                                     dailyHoroscopeFragmentFr: DailyHoroscopeFragment) : SettingsPagerAdapter {
        val settingsAdapter = SettingsPagerAdapter(supportFragmentManager)
        settingsAdapter.addFrag(welcomeFr)
        settingsAdapter.addFrag(dailyHoroscopeFragmentFr)

        return settingsAdapter
    }

    //set settings to view pager
    fun settingsViewPager(settingsAdapter : SettingsPagerAdapter){
        viewpager.setPageTransformer(false, ViewPager.PageTransformer { view, fl ->  view.alpha = Math.abs(Math.abs(fl) - 1) })

        viewpager.setBackgroundResource(R.drawable.bg_s3)
        viewpager.setScaleType(1)
        viewpager.setOnTouchListener { view, motionEvent -> true }
        viewpager.setOverlapPercentage(0.8f)
        viewpager.adapter = settingsAdapter
    }

    fun previewNextPage(pos : Int) { viewpager.currentItem = viewpager.currentItem + pos }

    //blur bg for each horoscope elements
    fun blur(view : View){
        viewpager.buildDrawingCache()
        val bkg = viewpager.drawingCache

        val radius : Float = 20f

        val overlay = Bitmap.createBitmap( view.measuredWidth.toInt(), view.measuredHeight.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(overlay)

        canvas.translate(-view.left.toFloat(), -view.top.toFloat())
        canvas.drawBitmap(bkg, 0f, 0f, null)

        val rs = RenderScript.create(this)
        val overLayAlloc = Allocation.createFromBitmap(rs, overlay)
        val blur = ScriptIntrinsicBlur.create(rs, overLayAlloc.element)

        blur.setInput(overLayAlloc)
        blur.setRadius(radius)
        blur.forEach(overLayAlloc)
        overLayAlloc.copyTo(overlay)

        view.setBackground(BitmapDrawable(resources, overlay))
        rs.destroy()
    }
}


