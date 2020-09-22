import kotlin.math.max
import kotlin.math.min

class Character(
    var health: Int = MAX_HEALTH,
    val level: Int = 1
) {
    fun alive() = health > MIN_HEALTH

    fun dealDamage(target: Character, damage: Int) = target.sufferAttack(damage)

    fun heal(target: Character, health: Int) = target.receiveCare(health)

    private fun sufferAttack(damage: Int) {
        health = max(health - damage, MIN_HEALTH)
    }

    private fun receiveCare(healing: Int) {
        if (alive())
            health = min(health + healing, MAX_HEALTH)
    }

    companion object {
        private const val MAX_HEALTH = 1000
        private const val MIN_HEALTH = 0
    }
}