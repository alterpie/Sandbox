package com.test.sandbox.libraries.characters.mapper

import com.test.sandbox.common.Mapper
import com.test.sandbox.libraries.characters.model.Character
import com.test.sandbox.libraries.characters.storage.model.CharacterEntity

internal object CharacterEntityMapper : Mapper<CharacterEntity, Character> {
    override fun invoke(entity: CharacterEntity): Character {
        return with(entity) { Character(id, name, species, gender, image, status, emptyList()) }
    }
}
