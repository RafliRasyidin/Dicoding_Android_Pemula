package id.kotlin.rscorona

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHospitalAdapter(private val listHospital: ArrayList<Hospital>): RecyclerView.Adapter<ListHospitalAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hospital, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHospital.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, address, photo, overview, identity) = listHospital[position]


        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(130, 160))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvAddress.text = address

        val mContext = holder.itemView.context
        holder.btnDetail.setOnClickListener {
            val moveDetail = Intent(mContext, DetailHospital::class.java)
            moveDetail.putExtra(DetailHospital.EXTRA_NAME, name)
            moveDetail.putExtra(DetailHospital.EXTRA_ADDRESS, address)
            moveDetail.putExtra(DetailHospital.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailHospital.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(DetailHospital.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_hospital)
        var tvName: TextView = itemView.findViewById(R.id.tv_name_hospital)
        var tvAddress: TextView = itemView.findViewById(R.id.tv_address)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
    }
}