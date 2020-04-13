package id.kotlin.rscorona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHospital: RecyclerView
    private var list: ArrayList<Hospital> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null){  //mengganti nilai dari judul halaman pada ActionBar menggunakan supportActionBar()
            (supportActionBar as ActionBar).title = "RS Rujukan Corona"
        }

        rvHospital = findViewById(R.id.rv_hospital)
        rvHospital.setHasFixedSize(true)

        list.addAll(HospitalData.listData)
        showRecycleList()
    }

    private fun showRecycleList() {
        rvHospital.layoutManager = LinearLayoutManager(this)
        val listHospitalAdapter = ListHospitalAdapter(list)
        rvHospital.adapter = listHospitalAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.icon_about ->{
                val moveAbout = Intent(this, AboutMe::class.java)
                startActivity(moveAbout)
            }
        }
    }
}
