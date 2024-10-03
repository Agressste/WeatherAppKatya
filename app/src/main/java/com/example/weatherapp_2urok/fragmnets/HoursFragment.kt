package com.example.weatherapp_2urok.fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp_2urok.MainViewModule
import com.example.weatherapp_2urok.R
import com.example.weatherapp_2urok.adapter.WeatherAdapter
import com.example.weatherapp_2urok.adapter.WeatherModel
import com.example.weatherapp_2urok.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModule by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRicView()
        model.liveDataCurrent.observe(viewLifecycleOwner) {

        }
    }

    private fun initRicView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel(
                "","12:00", "Rain",
                "9 C", "", "",
                "", ""),
            WeatherModel(
                "","13:00", "Rain",
                "10 C", "", "",
                "", ""),
            WeatherModel(
                "","16:00", "Heavy Rain",
                "7 C", "", "",
                "", "")
        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }

}