package com.test.sandbox.core.characters.mapper

import com.test.sandbox.common.Mapper
import com.test.sandbox.core.characters.model.Character
import com.test.sandbox.core.characters.storage.model.CharacterEntity

internal object CharacterMapper : Mapper<Character, CharacterEntity> {
    override fun invoke(character: Character): CharacterEntity {
        return with(character) { CharacterEntity(id, name, species, gender, image, status) }
    }
}
