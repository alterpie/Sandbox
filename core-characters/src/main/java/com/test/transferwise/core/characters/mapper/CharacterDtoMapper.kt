package com.test.transferwise.core.characters.mapper

import com.test.transferwise.common.Mapper
import com.test.transferwise.core.characters.model.Character
import com.test.transferwise.network.api.characters.model.CharacterDto

internal object CharacterDtoMapper : Mapper<CharacterDto, Character> {
    override fun invoke(dto: CharacterDto): Character {
        return with(dto) { Character(id, name, species, gender, image, status, episode) }
    }
}
