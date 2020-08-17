package com.skillbox.homeworkbuttle

sealed class BattleState { // создал изолированный класс

    data class Progress(
        val healthNowTeam1: Int,
        val healthNowTeam2: Int
    ) : BattleState()

    // создал подкласс для отслеживания состояния,
    // для более точного, так как будет меняться, а не просто проверять да или нет

    object WinTeam1 : BattleState() // проверяет состояние выиграла или нет

    object WinTeam2 : BattleState() // проверяет состояние выиграла или нет

    object Draw : BattleState() // проверяет состояние ничья или нет
}
