package com.skillbox.homeworkbuttle

import kotlin.random.Random

abstract class AbstractWarrior(
    maxHealth: Int,
    var chanceOfShot: Int,
    override var chanceAvoidDamage: Int,
    private var gun: AbstractWeapon

) : Warrior {

    var healthNow: Int = maxHealth

    override fun attack(enemy: Warrior) {
        try {
            val list = gun.getWeapon()
            var damage = 0
            for (i in list) {
                if (Random.nextInt(100) > chanceOfShot &&
                    Random.nextInt() > enemy.chanceAvoidDamage) {

                    damage += i.currentDamage()
                }
            }

            enemy.takeDamage(damage)
        } catch (e: AbstractWeapon.NoAmmoException) {
            gun.reload()
            println(e.message)
        }
    }

    override fun takeDamage(enemy: Int) {

        healthNow -= enemy
        if (healthNow <= 0) {
            healthNow = 0
            isKilled = true
        }
    }
}

