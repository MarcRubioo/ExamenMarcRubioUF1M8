package com.marcr.examenmarcrubiouf1m8.alumnes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.marcr.examenmarcrubiouf1m8.R
import com.marcr.examenmarcrubiouf1m8.data.repository.Companion.user
import com.marcr.examenmarcrubiouf1m8.databinding.FragmentAlumnesBinding


class FragmentAlumnes : Fragment() {
    private lateinit var binding: FragmentAlumnesBinding
    private val viewModel: ViewModelAlumnes by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlumnesBinding.inflate(inflater)

        binding.button.setOnClickListener{
            val nom = binding.editTextNom.text.toString()
            val grup = binding.editTextGruop.text.toString()
            val nota = binding.editTextNote.text.toString().toInt()

            if (nom.isNotBlank() && grup.isNotBlank()) {
                viewModel.afegirAlumne(requireContext(), nom, grup, nota)
                Toast.makeText(binding.root.context, "Usuari creat!", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(binding.root.context, "Introdueix els tres camps", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }
}