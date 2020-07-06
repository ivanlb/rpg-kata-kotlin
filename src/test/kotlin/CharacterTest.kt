import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CharacterTest {
    @Test
    fun `when created has health 1000`() {
        val character = Character()

        assertThat(character.health).isEqualTo(1000)
    }
}