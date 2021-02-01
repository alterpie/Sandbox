package com.test.transferwise.core.characters.mapper

import com.test.transferwise.common.Mapper
import com.test.transferwise.core.characters.model.Character
import com.test.transferwise.core.characters.storage.model.CharacterEntity

internal object CharacterEntityMapper : Mapper<CharacterEntity, Character> {
    override fun invoke(entity: CharacterEntity): Character {
        return with(entity) { Character(id, name, species, gender, image, status, emptyList()) }
    }
}
