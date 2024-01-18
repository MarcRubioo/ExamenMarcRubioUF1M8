package com.marcr.examenmarcrubiouf1m8.grup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcr.examenmarcrubiouf1m8.R
import com.marcr.examenmarcrubiouf1m8.adapter.UserAdapter
import com.marcr.examenmarcrubiouf1m8.databinding.FragmentGrupBinding


class FragmentGrup : Fragment() {
    private lateinit var binding: FragmentGrupBinding
    private val viewModel: ViewModelGroup by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGrupBinding.inflate(inflater)

        val manager = LinearLayoutManager(requireContext())
        val decoration = DividerItemDecoration(requireContext(), manager.orientation)


        binding.recyclerUsers.layoutManager = manager
        binding.recyclerUsers.addItemDecoration(decoration)

        viewModel.getUser(requireContext())

        viewModel.users.observe(viewLifecycleOwner){llistaUsers->
            binding.recyclerUsers.adapter = UserAdapter(llistaUsers)
        }

        return binding.root
    }
}