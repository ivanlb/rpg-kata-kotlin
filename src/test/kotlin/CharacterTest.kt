import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CharacterTest {
    @Test
    fun `when created has default values`() {
        val character = Character()

        assertThat(character.health).isEqualTo(1000)
        assertThat(character.level).isEqualTo(1)
        assertThat(character.alive).isTrue()
    }
}