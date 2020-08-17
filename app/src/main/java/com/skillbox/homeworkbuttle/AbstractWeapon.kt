package com.skillbox.homeworkbuttle

abstract class AbstractWeapon(
    var maxAmmo: Int,
    var fireType: FireType

) {
    var isHaveAmmo: Boolean = false

    var listWeapon: MutableList<Ammo> = mutableListOf()

    abstract fun createWeapon(): Ammo

    fun reload() {
        for (i in 0 until maxAmmo) {
            listWeapon.add(createWeapon())
            isHaveAmmo = true
        }
    }

    fun getWeapon(): List<Ammo> {
        if (listWeapon.isEmpty()) {
            throw NoAmmoException()
        }

        val list = mutableListOf<Ammo>()
        for (i in 0 until fireType.shot) {
            if (listWeapon.isEmpty()) {
                break
            }
            list.add(listWeapon.removeAt(0))
        }
        if (listWeapon.isEmpty()) {
            isHaveAmmo = true
        }
        return list
    }

    class NoAmmoException : Exception("Патроны закончились")
}