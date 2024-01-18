package com.marcr.examenmarcrubiouf1m8.adapter

import androidx.recyclerview.widget.RecyclerView
import com.marcr.examenmarcrubiouf1m8.data.User
import com.marcr.examenmarcrubiouf1m8.databinding.ItemUserBinding

class UserViewHolder (private var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

    fun render(userModel: User){
        binding.nomUser.text = userModel.name
        binding.grupUser.text = userModel.group
        binding.notaUser.text = userModel.note.toString()

    }
}