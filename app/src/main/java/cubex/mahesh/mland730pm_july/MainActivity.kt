package cubex.mahesh.mland730pm_july

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        var bmp = BitmapFactory.decodeResource(resources,
                R.drawable.code)

        gt.setOnClickListener({

            var fv = FirebaseVisionImage.fromBitmap(bmp)
            val detector = FirebaseVision.getInstance()
                    .visionTextDetector
            detector.detectInImage(fv).addOnSuccessListener {
             var list =    it.blocks
                for(x in list)
                {
                    tv1.text = "${tv1.text}  ${x.text}"
                }
            }
        })
    }
}
