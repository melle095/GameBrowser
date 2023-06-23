package com.leonov.gamebrowser

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.leonov.gamebrowser.Model.Results
import com.leonov.gamebrowser.databinding.GamesListCardViewsBinding
import com.squareup.picasso.Picasso

class Games_recycler_view_adapter(var games_list: ArrayList<Results>, val context: Context): RecyclerView.Adapter<Games_recycler_view_adapter.Games_item_viewholder> () {

    class Games_item_viewholder(val binding: GamesListCardViewsBinding):RecyclerView.ViewHolder(binding.root){
        val game_card_image: ViewPager2 = binding.gameCardImage
        val game_card_title: TextView = binding.gameCardTitle
        var platforms_list: RecyclerView = binding.platformsList
        val metacritic_text: TextView = binding.metacriticText
        val game_recommendation_img: ImageView = binding.gameRecommendationImg
        val release_date: TextView = binding.releaseDate
        val metacritic_icon: ImageView = binding.metacriticIcon
    }

    fun addItems(pos: Int, items: ArrayList<Results>) {
        games_list.addAll(pos, items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Games_item_viewholder {
        val binding = GamesListCardViewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Games_item_viewholder(binding)
    }

    override fun getItemCount(): Int {
        return games_list.size
    }

    override fun onBindViewHolder(holder: Games_item_viewholder, position: Int) {
//        Picasso.get().load(games_list[position].backgroundImage).into(holder.game_card_image)
        holder.game_card_title.text = games_list[position].name
        holder.metacritic_text.text = games_list[position].metacritic.toString()
        holder.release_date.text = context.getString(R.string.released)+games_list[position].released
        holder.metacritic_icon.setImageResource(R.drawable.metacritic)

        games_list[position].ratings.let {
            val highest_rating = games_list[position].ratings.maxBy { it.count!! }

            when (highest_rating.title) {
                "exceptional" -> {holder.game_recommendation_img.setImageResource(R.drawable.exceptional)}
                "recommended" -> {holder.game_recommendation_img.setImageResource(R.drawable.recommend)}
                "meh"         -> {holder.game_recommendation_img.setImageResource(R.drawable.meh)}
                "skip"        -> {holder.game_recommendation_img.setImageResource(R.drawable.skip)}
            }
        }

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        holder.platforms_list.layoutManager = linearLayoutManager
        holder.platforms_list.setHasFixedSize(true)
        val platforms = games_list[position].parentPlatforms
        val platformsRecyclerViewAdapter = Platforms_recycler_view_adapter(platforms)
        platformsRecyclerViewAdapter.notifyDataSetChanged()
        holder.platforms_list.adapter = platformsRecyclerViewAdapter

        val viewPager2Adapter = ViewPager2Adapter(games_list[position].shortScreenshots)
        holder.game_card_image.adapter = viewPager2Adapter
        viewPager2Adapter.notifyDataSetChanged()

    }
}


