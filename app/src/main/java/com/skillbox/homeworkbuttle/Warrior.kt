package com.skillbox.homeworkbuttle

interface Warrior {

    var isKilled: Boolean

    var chanceAvoidDamage: Int

    fun attack(enemy: Warrior)

    fun takeDamage(enemy: Int)
}
