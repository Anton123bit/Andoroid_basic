package com.skillbox.homeworkbuttle

import kotlin.random.Random

class Battle(
    private val team1: Team, // создаю команду 1 типа ТЕАМ
    private val team2: Team // создаю команду 2 типа ТЕАМ

) {

    var endBattle: Boolean = false

    fun getStateBattle(): BattleState {
        val isTeam1Alive = team1.haveAliveOrNot()
        val isTeam2Alive = team2.haveAliveOrNot()
        return when {
            isTeam1Alive && isTeam2Alive -> {
                BattleState.Progress(team1.sumHealthTeam(), team2.sumHealthTeam())
            }
            isTeam1Alive && !isTeam2Alive -> {
                endBattle = true
                println("Победила первая команда")
                BattleState.WinTeam1
            }
            !isTeam1Alive && isTeam2Alive -> {
                endBattle = true
                println("Победила вторая команда")
                BattleState.WinTeam2
            }
            else -> {
                endBattle = true
                println("Ничья")
                BattleState.Draw
            }
        }
    }

    fun nextIterable() {
        team1.team.shuffle()
        team2.team.shuffle()

        var i = 0
        while (i < team1.team.size) {

            if (team1.team.none { !it.isKilled } || team2.team.none { !it.isKilled }) {
                break
            }

            if (Random.nextBoolean()) {

                if (!team1.team[i].isKilled) {
                    team1.team[i].attack(team2.team.filter { !it.isKilled }.random())
                }

                if (!team2.team[i].isKilled) {
                    team2.team[i].attack(team1.team.filter { !it.isKilled }.random())
                }
            } else {

                if (!team2.team[i].isKilled) {
                    team2.team[i].attack(team1.team.filter { !it.isKilled }.random())
                }

                if (!team1.team[i].isKilled) {
                    team1.team[i].attack(team2.team.filter { !it.isKilled }.random())
                }
            }
            i++
        }
    }
}
