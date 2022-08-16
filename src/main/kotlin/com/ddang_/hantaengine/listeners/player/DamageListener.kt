package com.ddang_.hantaengine.listeners.player

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

//플레이어가 피해를 입을 때 동작하는 리스너 클래스입니다.

class DamageListener: Listener {
    @EventHandler
    fun onDamage(e: EntityDamageEvent) {
        val p = e.entity

        if (p !is Player) {
            return
        }
        
        //낙하 피해를 제거합니다.
        if (e.cause == EntityDamageEvent.DamageCause.FALL) {
            e.isCancelled = true
            return
        }

    }
}