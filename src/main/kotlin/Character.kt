import kotlin.math.max

class Character(
    var health: Int = INITIAL_HEALTH,
    val level: Int = 1
) {
    fun alive() = health > MIN_HEALTH

    fun dealDamage(target: Character, damage: Int) {
        target.sufferAttack(damage)
    }

    private fun sufferAttack(damage: Int) {
        health = max(health - damage, MIN_HEALTH)
    }

    companion object{
        private const val INITIAL_HEALTH = 1000
        private const val MIN_HEALTH = 0
    }
}