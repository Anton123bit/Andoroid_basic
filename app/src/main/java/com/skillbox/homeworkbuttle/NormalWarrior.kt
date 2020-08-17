package com.skillbox.homeworkbuttle

class NormalWarrior : AbstractWarrior(
    maxHealth = 120,
    chanceOfShot = 15,
    chanceAvoidDamage = 15,
    gun = Weapons.M16) {
    override var isKilled = false
}
