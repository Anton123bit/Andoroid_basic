package com.skillbox.homeworkbuttle

fun main() {
    while (true) {

        println("введите количество воинов: ")

        val team = readLine()?.toIntOrNull() ?: continue

        println("Начинается эпическая невидимая битва")

        val battle = Battle(
            team1 = Team(team),
            team2 = Team(team)
        )

        while (!battle.endBattle) {
            battle.nextIterable()
            println("${battle.getStateBattle()}")
        }
    }
}
