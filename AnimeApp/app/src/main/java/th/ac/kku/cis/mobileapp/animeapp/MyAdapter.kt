package th.ac.kku.cis.mobileapp.animeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private val newList: ArrayList<News>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading
        holder.adAnime.text=currentItem.animeWeb
    }

    override fun getItemCount(): Int {
        return newList.size
    }
    class MyViewHolder(itemView:View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){

        val titleImage: ShapeableImageView=itemView.findViewById(R.id.title_image)
        val tvHeading : TextView=itemView.findViewById(R.id.tvHeading)
        val adAnime : TextView=itemView.findViewById(R.id.adAnime)


        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
}