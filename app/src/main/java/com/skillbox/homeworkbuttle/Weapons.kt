package com.skillbox.homeworkbuttle

open class Weapons {

    object AK47 : AbstractWeapon(
        maxAmmo = 100,
        fireType = FireType.OneShot
    ) {
        override fun createWeapon(): Ammo {
            return Ammo.AMMO_HIGH
        }
    }

    object M16 : AbstractWeapon(
        maxAmmo = 120,
        fireType = FireType.OneShot
    ) {
        override fun createWeapon(): Ammo {
            return Ammo.AMMO_MIDDLE
        }
    }

    object DRAGUNOV : AbstractWeapon(
        maxAmmo = 100,
        fireType = FireType.ThreeShot
    ) {
        override fun createWeapon(): Ammo {
            return Ammo.AMMO_LOW
        }
    }

    object THOMPSON : AbstractWeapon(
        maxAmmo = 120,
        fireType = FireType.ThreeShot
    ) {
        override fun createWeapon(): Ammo {
            return Ammo.AMMO_HIGH
        }
    }
}
