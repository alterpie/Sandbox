package com.test.transferwise.core.characters

import com.test.transferwise.core.characters.mapper.CharacterMapper
import com.test.transferwise.network.api.characters.model.CharacterDto
import org.junit.Test

internal class CharacterMapperTest {

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
        val mapped = CharacterMapper(characterDto)

        assert(characterDto.name == mapped.name)
        assert(characterDto.species == mapped.species)
        assert(characterDto.gender == mapped.gender)
        assert(characterDto.id == mapped.id)
        assert(characterDto.image == mapped.image)
        assert(characterDto.status == mapped.status)
        assert(characterDto.episode == mapped.episodes)
    }
}
