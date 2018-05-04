package ado.com.testviewstyleprogrammatically

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val outImageView = findViewById<ImageView>(R.id.myImageView)
        val inLayout = generateLayoutFromCode()
        val imageBitmap = generateBitmap(inLayout)
        outImageView.setImageBitmap(imageBitmap)
    }

    @SuppressLint("InflateParams")
    fun generateLayoutFromCode() : View {
        return layoutInflater.inflate(R.layout.my_sublayout, null)
    }

    fun generateBitmap(view: View) : Bitmap {
        val specWidth = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val specHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        view.measure(specWidth, specHeight)
        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }

}
