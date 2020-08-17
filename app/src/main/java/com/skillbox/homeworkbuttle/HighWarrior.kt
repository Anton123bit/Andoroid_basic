package com.skillbox.homeworkbuttle

class HighWarrior : AbstractWarrior(
    maxHealth = 200,
    chanceOfShot = 30,
    chanceAvoidDamage = 30,
    gun = Weapons.THOMPSON) {
    override var isKilled = false
}
