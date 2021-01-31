package com.test.transferwise.feature.characters.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.loadAny
import coil.transform.CircleCropTransformation
import com.test.transferwise.core.characters.model.Character
import com.test.transferwise.feature.characters.databinding.CharactersItemCharacterBinding

internal class CharactersListAdapter(
    private val onItemClick: (Character) -> Unit
) : ListAdapter<Character, CharactersListAdapter.CharacterViewHolder>(CharacterItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharactersItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        with(holder.binding) {
            val character = getItem(position)
            image.load(character.image) {
                transformations(CircleCropTransformation())
            }
            root.setOnClickListener { onItemClick(character) }
            name.text = character.name
        }
    }

//    override fun onBindViewHolder(
//        holder: CharacterViewHolder,
//        position: Int,
//        payloads: MutableList<Any>
//    ) {
//        if (payloads.isEmpty()) {
//            super.onBindViewHolder(holder, position, payloads)
//        } else {
//            val payload = payloads.last()
//        }
//    }

    inner class CharacterViewHolder(
        val binding: CharactersItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
