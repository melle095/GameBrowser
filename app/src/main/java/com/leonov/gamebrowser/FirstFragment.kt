package com.leonov.gamebrowser

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leonov.gamebrowser.Common.Common
import com.leonov.gamebrowser.Interface.RetrofitServices
import com.leonov.gamebrowser.Model.ExampleJson2KtKotlin
import com.leonov.gamebrowser.Model.Results
import com.leonov.gamebrowser.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    var results= ArrayList<Results> ()
    private var page: Int = 1
    var isLoading:Boolean = false
    private val binding get() = _binding!!

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: Games_recycler_view_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        mService = Common.retrofitService
        _binding!!.gamesListRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        _binding!!.gamesListRecyclerView.layoutManager = layoutManager

        adapter = Games_recycler_view_adapter(results, activity?.baseContext!!)

        _binding!!.gamesListRecyclerView.adapter = adapter

        getGamesList(page)

        _binding?.gamesListRecyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?

                if (linearLayoutManager != null &&
                    linearLayoutManager.findLastCompletelyVisibleItemPosition() ==
                    (adapter.itemCount-2)) {

                    //bottom of list!
                    if (!isLoading) {
                        page++
                        getGamesList(page)
                        println("linearLayoutManager.findLastCompletelyVisibleItemPosition() ${linearLayoutManager.findLastCompletelyVisibleItemPosition()}")
                    }
                }
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getGamesList(page: Int) {

        isLoading = true
        mService.getMovieList(page).enqueue(object : Callback<ExampleJson2KtKotlin> {
            override fun onFailure(call: Call<ExampleJson2KtKotlin>, t: Throwable) {
                println("trace: ${t.stackTrace}")
                isLoading = false
            }
            override fun onResponse(call: Call<ExampleJson2KtKotlin>, response: Response<ExampleJson2KtKotlin>) {
                if (response.isSuccessful) {
                    results = (response.body() as ExampleJson2KtKotlin).results
                    adapter.addItems(adapter.itemCount,results)
                    adapter.notifyDataSetChanged()
                    println("the new items count: ${results.size}")
                    println("the new adapter size: ${adapter.itemCount}")
                } else {
                    println("Response failed. Code: ${response.code()}")
                }
                isLoading = false
            }
        })
    }
}