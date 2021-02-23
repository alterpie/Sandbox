package com.test.sandbox.core.characters

import com.test.sandbox.core.characters.mapper.CharacterDtoMapper
import com.test.sandbox.network.api.characters.model.CharacterDto
import org.junit.Test

internal class CharacterDtoMapperTest {

    @Test
    fun `should map character dto`() {
        val characterDto = CharacterDto(
            1L,
            "name",
            "species",
            "gender",
            "image",
            "status",
            "type",
            listOf("episode1, episode2")
        )
        val mapped = CharacterDtoMapper(characterDto)

        assert(characterDto.name == mapped.name)
        assert(characterDto.species == mapped.species)
        assert(characterDto.gender == mapped.gender)
        assert(characterDto.id == mapped.id)
        assert(characterDto.image == mapped.image)
        assert(characterDto.status == mapped.status)
        assert(characterDto.episode == mapped.episodes)
    }
}
