package com.leonov.gamebrowser

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.leonov.gamebrowser.Model.ShortScreenshots
import com.leonov.gamebrowser.databinding.GamesListCardViewsBinding
import com.leonov.gamebrowser.databinding.ScreenshotItemBinding
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class ViewPager2Adapter (val screenshot_list: ArrayList<ShortScreenshots>):
    RecyclerView.Adapter<ViewPager2Adapter.ViewPager2ViewHolder>() {

    class ViewPager2ViewHolder(val binding: ScreenshotItemBinding):RecyclerView.ViewHolder(binding.root){
        val screenshot_img: ImageView = binding.screenShotImg
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2Adapter.ViewPager2ViewHolder {
        val binding = ScreenshotItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPager2Adapter.ViewPager2ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPager2Adapter.ViewPager2ViewHolder, position: Int) {
        Picasso.get()
            .load(screenshot_list[position].image)
//            .networkPolicy(NetworkPolicy.OFFLINE)
            .fit()
            .into(holder.screenshot_img)
    }

    override fun getItemCount(): Int {
        return screenshot_list.size
    }
}