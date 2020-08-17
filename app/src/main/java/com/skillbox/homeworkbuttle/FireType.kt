package com.skillbox.homeworkbuttle

sealed class FireType(

    val shot: Int

) {

    object OneShot : FireType(1)
    object ThreeShot : FireType(3)
}
