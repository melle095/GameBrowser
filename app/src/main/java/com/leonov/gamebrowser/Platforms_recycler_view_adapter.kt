package com.leonov.gamebrowser

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.leonov.gamebrowser.Model.ParentPlatforms
import com.leonov.gamebrowser.databinding.PlatformItemBinding


class Platforms_recycler_view_adapter(val platform_list: ArrayList<ParentPlatforms>) : RecyclerView.Adapter<Platforms_recycler_view_adapter.Platforms_item_viewholder> (){
    class Platforms_item_viewholder(val binding: PlatformItemBinding):RecyclerView.ViewHolder(binding.root){
        val platform_icon: ImageView = binding.platformIcon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Platforms_item_viewholder {
        val binding = PlatformItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Platforms_item_viewholder(binding)
    }

    override fun getItemCount(): Int {
        return platform_list.size
    }

    override fun onBindViewHolder(holder: Platforms_item_viewholder, position: Int) {

        when (platform_list[position]?.platform?.id) {
            1 -> {
//                platform_icon = R.drawable.windows
                holder.platform_icon.setImageResource(R.drawable.windows)
            }             //pc
            2 -> {
//                platform_icon = R.drawable.playstation
                holder.platform_icon.setImageResource(R.drawable.playstation)
            }         //PlayStation
            3 -> {
//                platform_icon = R.drawable.xbox
                holder.platform_icon.setImageResource(R.drawable.xbox)
            }             //Xbox
            4 -> {
                holder.platform_icon.setImageResource(R.drawable.android)
//                platform_icon = R.drawable.android
            }         //Android
            5 -> {
                holder.platform_icon.setImageResource(R.drawable.apple)
//                platform_icon = R.drawable.apple
            }            //Apple Mac
            6 -> {
                holder.platform_icon.setImageResource(R.drawable.linux)
//                platform_icon = R.drawable.linux
            }         //Linux
            7 -> {
                holder.platform_icon.setImageResource(R.drawable.nintendo)
//                platform_icon = R.drawable.nintendo
            }         //Nintendo
        }
    }
}
