package com.skillbox.homeworkbuttle

class MediumWarrior : AbstractWarrior(
    maxHealth = 150,
    chanceOfShot = 25,
    chanceAvoidDamage = 25,
    gun = Weapons.DRAGUNOV) {
    override var isKilled = false
}
