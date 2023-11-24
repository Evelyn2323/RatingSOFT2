package com.example.ratingsoft.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ratingsoft.R
import com.example.ratingsoft.databinding.FragmentHomeBinding
import com.example.senakitchnew.ui.home.HomeViewModel
import com.example.senakitchnew.ui.home.ProductAdapter



private val Any.textHome: Unit
    get() = Unit

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView) // Asegúrate de que el ID sea correcto
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.contentData.observe(viewLifecycleOwner) { newData ->
            val adapter = ProductAdapter(newData)
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
