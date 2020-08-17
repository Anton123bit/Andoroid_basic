package com.skillbox.homeworkbuttle

import kotlin.random.Random

class Team(
    var quantityWarrior: Int
) {

    var team: MutableList<Warrior> = mutableListOf()

    init {

        team = createTeam() as MutableList<Warrior>
    }

    private fun createTeam(): List<Warrior> {
        val list = mutableListOf<Warrior>()
        for (i in 0 until quantityWarrior) {
            val element = when (Random.nextInt(100)) {
                in 0..40 -> LowWarrior()
                in 41..50 -> NormalWarrior()
                in 51..60 -> MediumWarrior()
                else -> HighWarrior()
            }
            list.add(element)
        }
        return list
    }

    fun haveAliveOrNot(): Boolean {
        for (i in team) {
            if (!i.isKilled) {
                return true
            }
        }
        return false
    }

    fun sumHealthTeam(): Int {
        val list = mutableListOf<Int>()
        for (i in team) {
            list.add((i as AbstractWarrior).healthNow)
        }
        return list.sum()
    }
}
