package com.test.transferwise.core.characters.mapper

import com.test.transferwise.core.characters.model.Character
import com.test.transferwise.network.api.characters.model.CharacterDto

internal object CharacterMapper {
    fun map(dto: CharacterDto): Character {
        return with(dto) { Character(id, name, species, gender, url, status) }
    }
}
