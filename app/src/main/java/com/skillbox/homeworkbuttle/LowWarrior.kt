package com.skillbox.homeworkbuttle

class LowWarrior : AbstractWarrior(
    maxHealth = 100,
    chanceOfShot = 10,
    chanceAvoidDamage = 10,
    gun = Weapons.AK47) {
    override var isKilled = false
}
