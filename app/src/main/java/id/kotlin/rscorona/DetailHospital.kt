package id.kotlin.rscorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailHospital : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_IDENTITY = "extra_identity"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_ADDRESS = "extra_address"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hospital)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_name_hospital)
        val imgSetPhoto: ImageView = findViewById(R.id.img_hospital)
        val tvSetIdentity: TextView = findViewById(R.id.tv_content_identity)
        val tvSetOverview: TextView = findViewById(R.id.tv_content_overview)

        val name = intent.getStringExtra(EXTRA_NAME)
        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val identity = intent.getStringExtra(EXTRA_IDENTITY)
        val overview = intent.getStringExtra(EXTRA_OVERVIEW)

        tvSetName.text = name
        Glide.with(this)
            .load(photo)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetIdentity.text = identity
        tvSetOverview.text = overview

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
