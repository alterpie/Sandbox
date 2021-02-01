package com.test.transferwise.core.characters.mapper

import com.test.transferwise.common.Mapper
import com.test.transferwise.core.characters.model.Character
import com.test.transferwise.core.characters.storage.model.CharacterEntity

internal object CharacterMapper : Mapper<Character, CharacterEntity> {
    override fun invoke(character: Character): CharacterEntity {
        return with(character) { CharacterEntity(id, name, species, gender, image, status) }
    }
}
