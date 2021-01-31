package com.test.transferwise.feature.characters.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.test.transferwise.core.characters.model.Character

internal class CharacterItemCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.gender == newItem.gender
            && oldItem.name == newItem.name
            && oldItem.species == newItem.species
            && oldItem.status == newItem.status
            && oldItem.image == newItem.image
    }
}
