package com.example.melosphere

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.melosphere.databinding.FragmentHomeBinding
import com.google.android.material.navigation.NavigationView


class HomeFragment : Fragment() , NavigationView.OnNavigationItemSelectedListener {
    //Access Token:
    //YWQ2M2ZhZTNiMDM4NDRmYjkyNzUwYjM4MjUyYzExYWI6M2ZmMmM1Nzc3NGNmNGQ3Njg0NjFhZmI1NzY4YWNiYjA=
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val trendingRecyclerView = binding.trendingList
        trendingRecyclerView.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                true
            )
        )
        return binding.root
    }

    private fun generateToken(){
//        String url =
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}