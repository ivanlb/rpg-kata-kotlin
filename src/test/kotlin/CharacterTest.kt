import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CharacterTest {
    @Test
    fun `when created has default values`() {
        val character = Character()

        assertThat(character.health).isEqualTo(1000)
        assertThat(character.level).isEqualTo(1)
        assertThat(character.alive()).isTrue()
    }

    @Test
    fun `characters can deal damage to characters`() {
        val target = Character()

        Character().dealDamage(target, damage = 300)

        assertThat(target.health).isEqualTo(700)
    }

    @Test
    fun `when damage received exceeds current health, health becomes 0 and the character dies`() {
        val target = Character()

        Character().dealDamage(target, damage = 1100)

        assertThat(target.health).isEqualTo(0)
        assertThat(target.alive()).isFalse()
    }

    @Test
    fun `a character can heal a character`() {
        val target = Character(health = 800)

        Character().heal(target, 100)

        assertThat(target.health).isEqualTo(900)
    }

    @Test
    fun `healing cannot raise health above 1000`() {
        val target = Character(health = 800)

        Character().heal(target, 300)

        assertThat(target.health).isEqualTo(1000)
    }

    @Test
    fun `dead characters cannot be healed`() {
        val deadCharacter = Character(health = 0)

        Character().heal(deadCharacter, 300)

        assertThat(deadCharacter.health).isEqualTo(0)
        assertThat(deadCharacter.alive()).isFalse()
    }
}