package com.example.assignment3

import android.annotation.SuppressLint
import android.media.Image
import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RvItemBinding


class BestPracticeAdapter:RecyclerView.Adapter<BestPracticeAdapter.ViewHolder> (){
    private var itemList :List<CardItem> = emptyList()    // *changing
    data class CardItem(var title: String,
                        var description : String,
                        var date : String,
                        var rating : String,
                        var image: Int,
    )


    class ViewHolder(val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cardItem: CardItem){
            binding.txtTitle.text = cardItem.title   // *changing
            binding.txtDescription.text = cardItem.description
            binding.txtDate.text = cardItem.date
            binding.txtRating.text = cardItem.rating
            binding.image.setImageResource(cardItem.image)

            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"Movies",Toast.LENGTH_SHORT).show()
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun ubdateList(newList: List<CardItem>){
        val diffUtilCallback = MyDiffutil(oldList =this.itemList, newList =newList)
        this.itemList = newList
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallback)
        diffUtilResult.dispatchUpdatesTo(this)
    }



}