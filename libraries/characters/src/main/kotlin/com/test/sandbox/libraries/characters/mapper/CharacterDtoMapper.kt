package com.test.sandbox.libraries.characters.mapper

import com.test.sandbox.common.Mapper
import com.test.sandbox.libraries.characters.model.Character
import com.test.sandbox.network.api.characters.model.CharacterDto

internal object CharacterDtoMapper : Mapper<CharacterDto, Character> {
    override fun invoke(dto: CharacterDto): Character {
        return with(dto) { Character(id, name, species, gender, image, status, episode) }
    }
}
