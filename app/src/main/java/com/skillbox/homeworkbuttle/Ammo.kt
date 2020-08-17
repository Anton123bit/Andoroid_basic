package com.skillbox.homeworkbuttle

import kotlin.random.Random

enum class Ammo(
    val damage: Int,
    val chanceCriticalDamage: Int,
    val coefficientCriticalDamage: Int

) {
    AMMO_LOW(damage = 75, chanceCriticalDamage = 100, coefficientCriticalDamage = 35),
    AMMO_MIDDLE(damage = 80, chanceCriticalDamage = 100, coefficientCriticalDamage = 40),
    AMMO_HIGH(damage = 85, chanceCriticalDamage = 100, coefficientCriticalDamage = 80);
    open fun currentDamage(): Int {
        val currentDamage = (damage)
        if (currentDamage >= Random.nextInt(chanceCriticalDamage)) {
            return(currentDamage)
        } else
            (return (currentDamage * coefficientCriticalDamage))
    }
}
