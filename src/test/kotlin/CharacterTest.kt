import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CharacterTest {
    @Test
    fun `when created has default values`() {
        val character = Character()

        assertThat(character.health).isEqualTo(INITIAL_HEALTH)
        assertThat(character.level).isEqualTo(1)
        assertThat(character.alive()).isTrue()
    }

    @Test
    fun `characters can deal damage to characters`() {
        val character = Character()
        val target = Character()

        character.dealDamage(target, damage = 300)

        assertThat(target.health).isEqualTo(700)
    }

    @Test
    fun `when damage received exceeds current health, health becomes 0 and the character dies`() {
        val character = Character()
        val target = Character()

        character.dealDamage(target, damage = 1100)

        assertThat(target.health).isEqualTo(0)
        assertThat(target.alive()).isFalse()
    }

    companion object {
        private const val INITIAL_HEALTH = 1000
    }
}